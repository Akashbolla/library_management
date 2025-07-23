package servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("🔐 Login Attempt: " + username);

        if (UserDAO.validateUser(username, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);

            Cookie ck = new Cookie("username", username);
            ck.setMaxAge(60 * 30);
            res.addCookie(ck);

            res.sendRedirect("dashboard.jsp");
        } else {
            res.sendRedirect("login.jsp?error=1");
        }
    }
}





 