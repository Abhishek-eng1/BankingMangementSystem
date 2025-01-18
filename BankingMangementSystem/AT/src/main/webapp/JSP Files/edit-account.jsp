<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Account</title>
</head>
<body>
    <h2>Edit Account</h2>
    <form action="update" method="post">
        <input type="hidden" name="accountNumber" value="${account.accountNumber}">

        <label for="accountHolder">Account Holder:</label>
        <input type="text" id="accountHolder" name="accountHolder" value="${account.accountHolder}" required><br><br>

        <label for="balance">Balance:</label>
        <input type="number" id="balance" name="balance" step="0.01" value="${account.balance}" required><br><br>

        <label for="accountType">Account Type:</label>
        <select id="accountType" name="accountType" required>
            <option value="Savings" ${account.accountType == 'Savings' ? 'selected' : ''}>Savings</option>
            <option value="Current" ${account.accountType == 'Current' ? 'selected' : ''}>Current</option>
        </select><br><br>

        <input type="submit" value="Update Account">
    </form>
</body>
</html>
