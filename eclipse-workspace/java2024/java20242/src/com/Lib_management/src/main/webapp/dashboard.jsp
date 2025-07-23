<%@ page language="java" session="true" %>
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Welcome, <%= username %>!</h1>

    <ul type="none">
        <li><a href="addBook.jsp">Add Book</a></li>
        <li><a href="viewBooks.jsp">Manage Books</a></li>
        <li><a href="viewUsers.jsp">Manage Users</a></li>
        <li><a href="logout">Logout</a></li>
    </ul>
</body>
</html>



