package com.banking.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AccountServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AccountDAO dao;

    public UserServlet() {
        super();
    }

    public void init() {
        dao = new AccountDAO();
    }

    // DoGet method to handle requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;

            case "/insert":
                insertAccount(request, response);
                break;

            case "/edit":
                showEditForm(request, response);
                break;

            case "/update":
                updateAccount(request, response);
                break;

            case "/delete":
                deleteAccount(request, response);
                break;

            case "/list":
                listAccounts(request, response);
                break;

            case "/view":
                viewAccount(request, response);
                break;

            default:
                listAccounts(request, response);
                break;
        }
    }

    // DoPost method to handle form submissions
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    // Show the form for adding a new account
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("account-form.jsp");
        dispatcher.forward(request, response);
    }

    // Insert a new account to the database
    private void insertAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String accountHolder = request.getParameter("accountHolder");
        double balance = Double.parseDouble(request.getParameter("balance"));
        String accountType = request.getParameter("accountType");

        Account newAccount = new Account(accountNumber, accountHolder, balance, accountType);
        dao.saveAccount(newAccount);
        response.sendRedirect("account-list.jsp");
    }

    // Show the form to edit an existing account
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        Object existingAccount = dao.getAccount(accountNumber);

        request.setAttribute("account", existingAccount);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-account.jsp");
        dispatcher.forward(request, response);
    }

    // Update account information in the database
    private void updateAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String accountHolder = request.getParameter("accountHolder");
        double balance = Double.parseDouble(request.getParameter("balance"));
        String accountType = request.getParameter("accountType");

        Account updatedAccount = new Account(accountNumber, accountHolder, balance, accountType);
        dao.updateAccount(updatedAccount);
        response.sendRedirect("account-list.jsp");
    }

    // Delete an account from the database
    private void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        dao.deleteAccount(accountNumber);
        response.sendRedirect("account-list.jsp");
    }

    // List all accounts from the database
    private void listAccounts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("accountList", dao.getAllAccounts());
        RequestDispatcher dispatcher = request.getRequestDispatcher("account-list.jsp");
        dispatcher.forward(request, response);
    }

    // View a single account's details
    private <Account> void viewAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        Account account = dao.getAccount(accountNumber);

        request.setAttribute("account", account);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view-account.jsp");
        dispatcher.forward(request, response);
    }

    private class AccountDAO {
        public <Account> Account getAccount(String accountNumber) {
            return null;
        }

        public void updateAccount(Account updatedAccount) {
        }

        public void deleteAccount(String accountNumber) {
        }

        public void saveAccount(Account newAccount) {

        }

        public Object getAllAccounts() {
                return null;
        }
    }

    private class Account {
        public Account(String accountNumber, String accountHolder, double balance, String accountType) {
        }
    }
}
