<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>
</head>
<body>
    <h2>Create a New Account</h2>
    <form action="insert" method="post">
        <label for="accountNumber">Account Number:</label>
        <input type="text" id="accountNumber" name="accountNumber" required><br><br>

        <label for="accountHolder">Account Holder:</label>
        <input type="text" id="accountHolder" name="accountHolder" required><br><br>

        <label for="balance">Initial Balance:</label>
        <input type="number" id="balance" name="balance" step="0.01" required><br><br>

        <label for="accountType">Account Type:</label>
        <select id="accountType" name="accountType" required>
            <option value="Savings">Savings</option>
            <option value="Current">Current</option>
        </select><br><br>

        <input type="submit" value="Create Account">
    </form>
</body>
</html>
