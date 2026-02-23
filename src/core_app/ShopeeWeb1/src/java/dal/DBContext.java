package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
     static final String DB_URL = 
    
 "jdbc:sqlserver://localhost:1433;"
+ "databaseName=ShopeeDB;"
+ "encrypt=true;"
+ "trustServerCertificate=true;";

String user = "sa";
String pass = "123456";

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(DB_URL, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}