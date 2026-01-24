/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package importer;

import db.DBConnection;
import util.CSVReader;
import java.sql.*;

public class OrderImporter {
     public static void run(String path) {
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(
                 "INSERT INTO orders VALUES (?,?,?,?)")) {

            for (String[] r : CSVReader.read(path)) {
                Timestamp t;
                try {
                    t = Timestamp.valueOf(r[3]);
                } catch (Exception e) { continue; }

                ps.setInt(1, Integer.parseInt(r[0]));
                ps.setInt(2, Integer.parseInt(r[1]));
                ps.setLong(3, Long.parseLong(r[2]));
                ps.setTimestamp(4, t);
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception e) {}
    }
}
