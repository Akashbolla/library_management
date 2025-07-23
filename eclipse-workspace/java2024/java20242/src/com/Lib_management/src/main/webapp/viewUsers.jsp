<%@ page import="java.util.*, beans.UserBean, dao.UserDAO" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Registered Users</title>
    <link rel="stylesheet" href="style.css">
    
</head>
<body>

    <h2 align="center">📋 Registered Users</h2>
      <table border="1" align="center" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>Password</th>
            <th>Actions</th>
        </tr>
        <%
        List<UserBean> list = UserDAO.getAllUsers();
        for(UserBean u : list){
    %>

       
        <tr>
            <td><%= u.getId() %></td>
            <td><%= u.getName() %></td>
            <td><%= u.getEmail() %></td>
            <td><%= u.getPassword() %></td>
            <td>
                <a href="editUser.jsp?id=<%= u.getId() %>">Edit</a> |
                <a href="DeleteUserServlet?id=<%= u.getId() %>" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
    

    <div class="center-link">
        <a href="dashboard.jsp">⬅ Back to Dashboard</a>
    </div>

</body>
</html>




