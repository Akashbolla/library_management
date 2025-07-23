package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect implements DBinfo {

    public static Connection getCon() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, id, pwd);
            con.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
