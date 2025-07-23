<%@ page import="beans.BookBean, dao.BookDAO" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    BookBean book = BookDAO.getBookById(id);
%>
<html>
<head><title>Edit Book</title></head>
<body>
<h2>Edit Book</h2>
<form action="updateBook" method="post">
    <input type="hidden" name="id" value="<%= book.getId() %>" />
    Title: <input type="text" name="title" value="<%= book.getTitle() %>" /><br>
    Author: <input type="text" name="author" value="<%= book.getAuthor() %>" /><br>
    Quantity: <input type="number" name="quantity" value="<%= book.getQuantity() %>" /><br>
    <input type="submit" value="Update Book"/>
</form>
</body>
</html>
