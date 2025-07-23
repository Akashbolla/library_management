package servlets;

import beans.BookBean;
import dao.BookDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String title = req.getParameter("title");
            String author = req.getParameter("author");
            int quantity = Integer.parseInt(req.getParameter("quantity")); 

            BookBean book = new BookBean(id, title, author, quantity);

            if (BookDAO.updateBook(book)) {
                res.sendRedirect("viewBooks.jsp");
            } else {
                res.getWriter().println("Update failed");
            }
        } catch (Exception e) {
            e.printStackTrace(res.getWriter());
        }
    }
}

