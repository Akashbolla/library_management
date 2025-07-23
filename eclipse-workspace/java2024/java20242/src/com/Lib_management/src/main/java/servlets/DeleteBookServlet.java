package servlets;

import dao.BookDAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;


@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String idParam = req.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            res.getWriter().println("Missing book ID.");
            return;
        }

        try {
            int id = Integer.parseInt(idParam);
            BookDAO.deleteBook(id);
            res.sendRedirect("viewBooks.jsp");
        } catch (NumberFormatException e) {
            res.getWriter().println("Invalid book ID format.");
        }
    }
}


