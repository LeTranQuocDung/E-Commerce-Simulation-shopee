/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package importer;
import db.DBConnection;
import util.CSVReader;
import java.sql.*;

public class OrderItemImporter {
    public static void run(String path) {
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(
                 "INSERT INTO order_items VALUES (?,?,?,?,?)")) {

            for (String[] r : CSVReader.read(path)) {
                ps.setInt(1, Integer.parseInt(r[0]));
                ps.setInt(2, Integer.parseInt(r[1]));
                ps.setInt(3, Integer.parseInt(r[2]));
                ps.setInt(4, Integer.parseInt(r[3]));
                ps.setLong(5, Long.parseLong(r[4]));
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception e) {}
    }
}
