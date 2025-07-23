package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import beans.BookBean;
import dao.BookDAO;  // ✅ Updated to use BookDAO

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        BookBean book = new BookBean();
        book.setTitle(title);
        book.setAuthor(author);
        book.setQuantity(quantity);

        boolean success = BookDAO.addBook(book);

        if (success) {
            response.sendRedirect("dashboard.jsp");
        } else {
            response.sendRedirect("addBook.jsp?error=true");
        }
    }
}



