import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Random;

public class BankManagementSystem {
    private static HashMap<String, String[]> userDatabase = new HashMap<>(); // Stores username -> {password, accountNumber, balance}

    public static void main(String[] args) {
        showMainScreen();
    }

    private static void showMainScreen() {
        JFrame frame = new JFrame("Bank Management System - Main");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to Bank Management System");
        welcomeLabel.setBounds(80, 20, 250, 25);
        panel.add(welcomeLabel);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(80, 80, 100, 25);
        panel.add(loginButton);

        JButton signupButton = new JButton("Signup");
        signupButton.setBounds(200, 80, 100, 25);
        panel.add(signupButton);

        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                showLoginScreen();
            }
        });

        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                showSignupScreen();
            }
        });
    }

    private static void showSignupScreen() {
        JFrame signupFrame = new JFrame("Bank Management System - Signup");
        signupFrame.setSize(400, 250);
        signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        signupFrame.add(panel);
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Choose Username:");
        userLabel.setBounds(10, 20, 150, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(160, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Choose Password:");
        passwordLabel.setBounds(10, 50, 150, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(160, 50, 165, 25);
        panel.add(passwordText);

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(10, 100, 150, 25);
        panel.add(createAccountButton);

        signupFrame.setVisible(true);

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                } else if (userDatabase.containsKey(username)) {
                    JOptionPane.showMessageDialog(null, "Username already exists. Please choose a different one.");
                } else {
                    String accountNumber = generateAccountNumber();
                    userDatabase.put(username, new String[] {password, accountNumber, "0"}); // balance is 0 initially
                    JOptionPane.showMessageDialog(null, "Account created successfully! Your account number is: " + accountNumber);
                    signupFrame.dispose();
                    showMainScreen();
                }
            }
        });
    }

    private static void showLoginScreen() {
        JFrame frame = new JFrame("Bank Management System - Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel accountNumberLabel = new JLabel("Account No:");
        accountNumberLabel.setBounds(10, 50, 80, 25);
        panel.add(accountNumberLabel);

        JTextField accountNumberText = new JTextField(20);
        accountNumberText.setBounds(100, 50, 165, 25);
        panel.add(accountNumberText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 80, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 80, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 120, 80, 25);
        panel.add(loginButton);

        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String accountNumber = accountNumberText.getText();
                String password = new String(passwordText.getPassword());

                if (userDatabase.containsKey(username) &&
                        userDatabase.get(username)[0].equals(password) &&
                        userDatabase.get(username)[1].equals(accountNumber)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    frame.dispose();
                    openDashboard(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
                }
            }
        });
    }

    private static void openDashboard(String username) {
        JFrame dashboardFrame = new JFrame("Bank Dashboard");
        dashboardFrame.setSize(500, 400);
        dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        welcomeLabel.setBounds(50, 20, 300, 30);
        dashboardPanel.add(welcomeLabel);

        JLabel balanceLabel = new JLabel("Balance: $" + userDatabase.get(username)[2]);
        balanceLabel.setBounds(50, 60, 300, 30);
        dashboardPanel.add(balanceLabel);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(50, 100, 150, 30);
        dashboardPanel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50, 140, 150, 30);
        dashboardPanel.add(withdrawButton);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(50, 180, 150, 30);
        dashboardPanel.add(checkBalanceButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(50, 220, 150, 30);
        dashboardPanel.add(logoutButton);

        // Deposit Action
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog("Enter amount to deposit:");
                if (amountStr != null) {
                    try {
                        double amount = Double.parseDouble(amountStr);
                        double currentBalance = Double.parseDouble(userDatabase.get(username)[2]);
                        currentBalance += amount;
                        userDatabase.get(username)[2] = String.valueOf(currentBalance);
                        balanceLabel.setText("Balance: $" + currentBalance);
                        JOptionPane.showMessageDialog(null, "Deposit successful!");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid amount entered.");
                    }
                }
            }
        });

        // Withdraw Action
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
                if (amountStr != null) {
                    try {
                        double amount = Double.parseDouble(amountStr);
                        double currentBalance = Double.parseDouble(userDatabase.get(username)[2]);
                        if (amount > currentBalance) {
                            JOptionPane.showMessageDialog(null, "Insufficient balance.");
                        } else {
                            currentBalance -= amount;
                            userDatabase.get(username)[2] = String.valueOf(currentBalance);
                            balanceLabel.setText("Balance: $" + currentBalance);
                            JOptionPane.showMessageDialog(null, "Withdrawal successful!");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid amount entered.");
                    }
                }
            }
        });

        // Check Balance Action
        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double currentBalance = Double.parseDouble(userDatabase.get(username)[2]);
                JOptionPane.showMessageDialog(null, "Current Balance: $" + currentBalance);
            }
        });

        // Logout Action
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dashboardFrame.dispose();
                JOptionPane.showMessageDialog(null, "You have logged out.");
                showMainScreen();
            }
        });

        dashboardFrame.add(dashboardPanel);
        dashboardFrame.setVisible(true);
    }

    private static String generateAccountNumber() {
        Random random = new Random();
        return "ACC" + (100000 + random.nextInt(900000)); // Generates a 6-digit account number
    }
}