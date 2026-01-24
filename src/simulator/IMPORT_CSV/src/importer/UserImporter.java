
package importer;
import db.DBConnection;
import util.CSVReader;
import java.sql.*;

public class UserImporter {

    public static void run(String path) {
        String sql = "INSERT INTO users VALUES (?,?,?,?,?,?)";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            for (String[] r : CSVReader.read(path)) {
                try {
                    if (!r[2].contains("@")) continue; // email rác

                    ps.setInt(1, Integer.parseInt(r[0]));
                    ps.setString(2, r[1]);
                    ps.setString(3, r[2]);
                    ps.setString(4, r[3]);
                    ps.setLong(5, Long.parseLong(r[4]));
                    ps.setString(6, r.length > 5 ? r[5] : null);
                    ps.addBatch();
                } catch (Exception e) {}
            }
            ps.executeBatch();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
