package servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.UserDAO;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        if (UserDAO.deleteUser(id)) {
            res.sendRedirect("viewUsers.jsp");
        } else {
            res.getWriter().println("User delete failed!");
        }
    }
}

