// script.js

// Function to validate user registration form
function validateRegistrationForm() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const balance = document.getElementById("balance").value;

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

    return true;
}

// Function to handle user interactions (e.g., greeting)
function greetUser(username) {
    const greeting = document.getElementById("greeting");
    greeting.innerText = `Welcome, ${username}!`;
}

// Example: Auto-fill user data (dummy data for demonstration)
function autofillUserData() {
    document.getElementById("username").value = "john_doe";
    document.getElementById("password").value = "password123";
    document.getElementById("balance").value = 1000.0;
    alert("Dummy data has been pre-filled!");
}
