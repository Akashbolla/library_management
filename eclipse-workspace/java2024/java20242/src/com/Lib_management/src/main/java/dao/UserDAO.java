package dao;

import java.sql.*;
import java.util.*;
import beans.UserBean;
import util.DBconnect;

public class UserDAO {

    public static boolean addUser(UserBean user) {
        try (Connection con = DBconnect.getCon()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users(username, email, password) VALUES (?, ?, ?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int rows = ps.executeUpdate();
            System.out.println("Inserted user: " + user.getName() + ", " + user.getEmail());
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<UserBean> getAllUsers() {
        List<UserBean> list = new ArrayList<>();
        try (Connection con = DBconnect.getCon()) {
            System.out.println("🔍 getAllUsers() called");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserBean user = new UserBean();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
            System.out.println("✅ Total users fetched: " + list.size());
        } catch (Exception e) {
            System.out.println("❌ Error in getAllUsers()");
            e.printStackTrace();
        }
        return list;
    }

    public static boolean deleteUser(int id) {
        try (Connection con = DBconnect.getCon()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id = ?");
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static UserBean getUserById(int id) {
        UserBean user = null;
        try (Connection con = DBconnect.getCon()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserBean();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static boolean updateUser(UserBean user) {
        try (Connection con = DBconnect.getCon()) {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET username=?, email=?, password=? WHERE id=?"
            );
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean validateUser(String username, String password) {
        try (Connection con = DBconnect.getCon()) {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username = ? AND password = ?"
            );
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}






