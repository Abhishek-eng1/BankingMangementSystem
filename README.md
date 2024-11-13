# Banking Management System

## Overview
The **Banking Management System** is a Java-based application designed to handle basic banking operations. It allows users to create accounts, deposit and withdraw funds, view account details, and manage customer information. This project uses Object-Oriented Programming principles and is structured to demonstrate fundamental banking functionalities in a console-based environment.

## Features
- **Account Creation**: Add new customer accounts with personal information and a unique account number.
- **Deposit Funds**: Deposit money into customer accounts.
- **Withdraw Funds**: Withdraw money, ensuring account balance constraints.
- **Check Balance**: View the current balance for any customer account.
- **View Account Details**: Access customer information and account history.
- **Exit Application**: End the application safely.

## Technologies Used
- **Programming Language**: Java
- **Database (Optional)**: MySQL (for persistent data storage if required)
- **IDE**: Any Java-compatible IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans)

## Project Structure
The project is divided into multiple classes for modularity and ease of maintenance:
1. `Main.java`: Entry point of the application, which handles the main menu and application flow.
2. `Bank.java`: Core class that manages accounts, including creating, updating, and retrieving account details.
3. `Account.java`: Defines account properties, including account number, balance, and customer details.
4. `Customer.java`: Holds customer-specific information like name, address, and contact details.
5. `DatabaseConnection.java` (Optional): Manages the connection to the MySQL database if persistent storage is required.

## Installation & Setup
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Abhishek-eng1/BankingMangementSystem
