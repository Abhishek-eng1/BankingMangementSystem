<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Banking Management System</title>
    <style>
        /* CSS Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff; /* Soft background color */
            margin: 0;
            padding: 0;
        }

        /* Header */
        header {
            background-color: #007bff;
            color: white;
            text-align: center;
            padding: 20px;
            position: fixed;
            width: 100%;
            top: 0;
            left: 0;
            z-index: 1000;
        }

        header h1 {
            margin: 0;
            font-size: 2rem;
        }

        /* Main content container */
        .container {
            padding-top: 100px; /* Space for the fixed header */
            padding-bottom: 40px; /* Space for footer */
            text-align: center;
        }

        form {
            max-width: 500px;
            margin: 20px auto;
            padding: 20px;
            background: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="number"],
        input[type="tel"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 12px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        button {
            width: 100%;
            padding: 10px;
            background: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background: #218838;
        }

        #greeting {
            text-align: center;
            margin-top: 20px;
            font-size: 18px;
            color: #007bff;
        }

        .autofill-btn {
            margin-top: 10px;
            width: auto;
            padding: 10px 15px;
            background: #ffc107;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }

        .autofill-btn:hover {
            background: #e0a800;
        }

        #success-message {
            margin-top: 20px;
            text-align: center;
            color: #28a745;
            font-weight: bold;
        }

        /* Footer */
        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px;
            position: fixed;
            width: 100%;
            bottom: 0;
        }

    </style>
    <script>
        // JavaScript Functions
        function validateRegistrationForm() {
            const username = document.getElementById("username").value;
            const password = document.getElementById("password").value;
            const balance = document.getElementById("balance").value;
            const fullName = document.getElementById("full-name").value;
            const email = document.getElementById("email").value;
            const phone = document.getElementById("phone").value;

            if (username.trim() === "") {
                alert("Username cannot be empty!");
                return false;
            }

            if (password.length < 6) {
                alert("Password must be at least 6 characters long!");
                return false;
            }

            if (isNaN(balance) || balance <= 0) {
                alert("Please enter a valid initial balance!");
                return false;
            }

            if (fullName.trim() === "") {
                alert("Full name is required!");
                return false;
            }

            const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
            if (!emailPattern.test(email)) {
                alert("Please enter a valid email address!");
                return false;
            }

            const phonePattern = /^[0-9]{10}$/;
            if (!phonePattern.test(phone)) {
                alert("Please enter a valid phone number!");
                return false;
            }

            return true;
        }

        function greetUser(username) {
            const greeting = document.getElementById("greeting");
            greeting.innerText = `Welcome, ${username}!`;
        }

        function autofillUserData() {
            document.getElementById("username").value = "john_doe";
            document.getElementById("password").value = "password123";
            document.getElementById("balance").value = 1000.0;
            document.getElementById("full-name").value = "John Doe";
            document.getElementById("email").value = "johndoe@example.com";
            document.getElementById("phone").value = "1234567890";
            alert("Dummy data has been pre-filled!");
        }

        function showSuccessMessage() {
            const successMessage = document.getElementById("success-message");
            successMessage.innerText = "New User is Login Successfully!";
        }
    </script>
</head>
<body>

    <!-- Header Section -->
    <header>
        <h1>Banking Management System</h1>
    </header>

    <!-- Main Content Section -->
    <div class="container">
        <!-- Greeting Section -->
        <div id="greeting"></div>

        <!-- Registration Form -->
        <form onsubmit="event.preventDefault(); if (validateRegistrationForm()) { showSuccessMessage(); }">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="full-name">Full Name:</label>
            <input type="text" id="full-name" name="full-name" required>

            <label for="email">Email Address:</label>
            <input type="email" id="email" name="email" required>

            <label for="phone">Phone Number:</label>
            <input type="tel" id="phone" name="phone" required>

            <label for="balance">Initial Balance:</label>
            <input type="number" id="balance" name="balance" required>

            <button type="submit">Register User</button>
        </form>

        <!-- Success Message -->
        <div id="success-message"></div>

        <!-- Autofill Button -->
        <button class="autofill-btn" onclick="autofillUserData()">Auto-fill Dummy Data</button>
    </div>
</body>
</html>
