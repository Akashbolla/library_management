<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

    <h2>New User Registration</h2>
    <form action="register" method="post">
        Username : <input type="text" name="username" required /><br><br>
        Email : <input type="email" name="email" required /><br><br>
        Password : <input type="password" name="password" required /><br><br>
        <input type="submit" value="Register" />
    </form>

    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">❌ Registration failed. Try again.</p>
    <% } else if (request.getParameter("success") != null) { %>
        <p style="color:green;">✅ Registered successfully! <a href="login.jsp">Login here</a></p>
    <% } %>

    <br>
    <a href="login.jsp">Already registered? Login</a>

</body>
</html>

