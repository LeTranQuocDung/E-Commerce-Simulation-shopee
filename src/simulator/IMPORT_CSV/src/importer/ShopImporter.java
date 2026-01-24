
package importer;
import db.DBConnection;
import util.CSVReader;
import java.sql.*;

public class ShopImporter {
      public static void run(String path) {
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(
                 "INSERT INTO shops VALUES (?,?,?)")) {

            for (String[] r : CSVReader.read(path)) {
                ps.setInt(1, Integer.parseInt(r[0]));
                ps.setString(2, r[1]);
                ps.setDouble(3, Double.parseDouble(r[2]));
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception e) {}
    }
}

