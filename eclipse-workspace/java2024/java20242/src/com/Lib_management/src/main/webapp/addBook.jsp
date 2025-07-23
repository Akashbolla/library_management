<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
     <link rel="stylesheet" href="style.css">
</head>
<body>
    <h2>Add New Book</h2>
    <<form action="addBook" method="post">
  Title   : <input type="text" name="title" required><br>
  Author  : <input type="text" name="author" required><br>
  Quantity: <input type="number" name="quantity" required><br>
  <input type="submit" value="Add Book">
</form>
<a href="logout">Logout</a>

    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Error while adding book</p>
    <% } %>
</body>
</html>

