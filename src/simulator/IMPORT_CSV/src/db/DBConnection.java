package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        String url =
            "jdbc:sqlserver://localhost:1433;"
          + "databaseName=ImportCSVDB;"
          + "integratedSecurity=true;"
          + "encrypt=true;"
          + "trustServerCertificate=true";

        return DriverManager.getConnection(url);
    }
}
