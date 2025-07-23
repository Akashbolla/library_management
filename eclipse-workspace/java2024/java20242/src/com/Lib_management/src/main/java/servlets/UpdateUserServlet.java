package servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import beans.UserBean;
import dao.UserDAO;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("name");     
        String email = req.getParameter("email");       
        String password = req.getParameter("password");

        UserBean user = new UserBean();
        user.setId(id);
        user.setName(username);
        user.setEmail(email);                          
        user.setPassword(password);

        if (UserDAO.updateUser(user)) {
            res.sendRedirect("viewUsers.jsp");
        } else {
            res.getWriter().println("User update failed!");
        }
    }
}



