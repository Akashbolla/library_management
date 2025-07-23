<%@ page import="dao.UserDAO, beans.UserBean" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    UserBean user = UserDAO.getUserById(id);
%>
<html>
<head><title>Edit User</title></head>
<body>
    <form action="UpdateUserServlet" method="post">
        <input type="hidden" name="id" value="<%=user.getId()%>"/>
        Name: <input type="text" name="name" value="<%=user.getName()%>"/><br>
        Email: <input type="email" name="email" value="<%=user.getEmail()%>"/><br>
        Password: <input type="password" name="password" value="<%=user.getPassword()%>"/><br>
        <input type="submit" value="Update User"/>
    </form>
</body>
</html>



