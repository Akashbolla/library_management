package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import beans.UserBean;
import dao.UserDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

    	String username = req.getParameter("username");
    	String email = req.getParameter("email");
    	String password = req.getParameter("password");

    	UserBean user = new UserBean();
    	user.setName(username);
    	user.setEmail(email); 
    	user.setPassword(password);

        if (UserDAO.addUser(user)) {
            res.sendRedirect("login.jsp?msg=Registered successfully");
        } else {
            res.sendRedirect("register.jsp?error=1");
        }
    }
}

