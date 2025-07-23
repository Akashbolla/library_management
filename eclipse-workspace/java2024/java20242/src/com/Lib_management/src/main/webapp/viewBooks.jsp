<%@ page import="java.util.*, beans.BookBean, dao.BookDAO" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Management</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

    <h2 align="center">Book List</h2>

    <table border="1" align="center" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Actions</th>
        </tr>
        <%
            List<BookBean> books = BookDAO.getAllBooks();
            for(BookBean b : books) {
        %>
        <tr>
            <td><%= b.getId() %></td>
            <td><%= b.getTitle() %></td>
            <td><%= b.getAuthor() %></td>
            <td>
                <a href="editBook.jsp?id=<%= b.getId() %>">Edit</a> |
                <a href="deleteBook?id=<%= b.getId() %>" onclick="return confirm('Are you sure you want to delete this book?')">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>

    <div style="text-align: center; margin-top: 20px;">
        <a href="dashboard.jsp">Back to Dashboard</a>
    </div>

</body>
</html>



