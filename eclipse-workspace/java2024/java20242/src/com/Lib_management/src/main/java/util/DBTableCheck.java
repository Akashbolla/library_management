package util;

import java.sql.*;
import util.DBconnect;

public class DBTableCheck {
    public static void main(String[] args) {
        try (Connection con = DBconnect.getCon()) {
            if (con != null) {
                ResultSet rs = con.getMetaData().getTables(null, null, "USERS", new String[]{"TABLE"});
                if (rs.next()) {
                    System.out.println("✅ USERS table exists in DB.");
                } else {
                    System.out.println("❌ USERS table not found in this schema.");
                }
            } else {
                System.out.println("❌ Connection is null. Check DBconnect credentials.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

