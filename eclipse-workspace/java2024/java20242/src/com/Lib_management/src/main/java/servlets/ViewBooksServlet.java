package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;
import dao.BookDAO;
import beans.BookBean;
@WebServlet("/viewBooks")
public class ViewBooksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	List<BookBean> list = BookDAO.getAllBooks();
    	System.out.println("Book list size: " + list.size());
    	request.setAttribute("bookList", list);
    	RequestDispatcher rd = request.getRequestDispatcher("viewBooks.jsp");
    	rd.forward(request, response);
    }
}
