package helperPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class JDBCHelper {
    private static final String url = "jdbc:mysql://localhost:3306/products";
    private static final String user = "admin";
    private static final String password = "admin";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public List<String> executeSQL(String query) throws SQLException {
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            List<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

}
