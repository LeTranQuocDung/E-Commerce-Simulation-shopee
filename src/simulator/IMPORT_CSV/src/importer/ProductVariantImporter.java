/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package importer;

import db.DBConnection;
import util.CSVReader;
import java.sql.*;

public class ProductVariantImporter {
     public static void run(String path) {
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(
                 "INSERT INTO product_variants VALUES (?,?,?,?,?,?)")) {

            for (String[] r : CSVReader.read(path)) {
                int stock = Integer.parseInt(r[4]);
                if (stock < 0) continue; // ❌ stock âm

                ps.setInt(1, Integer.parseInt(r[0]));
                ps.setInt(2, Integer.parseInt(r[1]));
                ps.setString(3, r[2]);
                ps.setString(4, r[3]);
                ps.setInt(5, stock);
                ps.setDouble(6, Double.parseDouble(r[5]));
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception e) {}
    }
}
