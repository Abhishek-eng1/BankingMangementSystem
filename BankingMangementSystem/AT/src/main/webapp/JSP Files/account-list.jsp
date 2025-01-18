<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account List</title>
</head>
<body>
    <h2>All Accounts</h2>
    <table border="1">
        <tr>
            <th>Account Number</th>
            <th>Account Holder</th>
            <th>Balance</th>
            <th>Account Type</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="account" items="${accountList}">
            <tr>
                <td>${account.accountNumber}</td>
                <td>${account.accountHolder}</td>
                <td>${account.balance}</td>
                <td>${account.accountType}</td>
                <td>
                    <a href="view?accountNumber=${account.accountNumber}">View</a> |
                    <a href="edit?accountNumber=${account.accountNumber}">Edit</a> |
                    <a href="delete?accountNumber=${account.accountNumber}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
