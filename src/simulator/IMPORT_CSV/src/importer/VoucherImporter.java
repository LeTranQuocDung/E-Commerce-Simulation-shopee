/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package importer;

import db.DBConnection;
import util.CSVReader;
import java.sql.*;
public class VoucherImporter {
  public static void run(String path) {
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(
                 "INSERT INTO vouchers VALUES (?,?,?,?,?)")) {

            for (String[] r : CSVReader.read(path)) {
                ps.setString(1, r[0]);
                ps.setLong(2, Long.parseLong(r[1]));
                ps.setLong(3, Long.parseLong(r[2]));
                ps.setDate(4, Date.valueOf(r[3]));
                ps.setDate(5, Date.valueOf(r[4]));
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception e) {}
    }  
}
