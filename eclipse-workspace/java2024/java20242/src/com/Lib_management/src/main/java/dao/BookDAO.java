package dao;

import java.sql.*;
import java.util.*;
import beans.BookBean;
import util.DBconnect;

public class BookDAO {
    public static boolean addBook(BookBean book) {
        boolean status = false;
        try (Connection con = DBconnect.getCon()) {
            String sql = "INSERT INTO books(title, author, quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getQuantity());
            status = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static List<BookBean> getAllBooks() {
        List<BookBean> bookList = new ArrayList<>();
        try (Connection con = DBconnect.getCon()) {
            String sql = "SELECT * FROM books";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookBean book = new BookBean();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setQuantity(rs.getInt("quantity"));
                bookList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public static BookBean getBookById(int id) {
        BookBean book = null;
        try (Connection con = DBconnect.getCon()) {
            String sql = "SELECT * FROM books WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                book = new BookBean();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setQuantity(rs.getInt("quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public static boolean updateBook(BookBean book) {
        boolean status = false;
        try (Connection con = DBconnect.getCon()) {
            String sql = "UPDATE books SET title = ?, author = ?, quantity = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getQuantity());
            ps.setInt(4, book.getId());
            status = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static boolean deleteBook(int id) {
        boolean status = false;
        try (Connection con = DBconnect.getCon()) {
            String sql = "DELETE FROM books WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}

