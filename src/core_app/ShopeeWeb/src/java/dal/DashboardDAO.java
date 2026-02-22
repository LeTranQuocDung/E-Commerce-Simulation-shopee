package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// Nếu DBContext của ông báo lỗi đỏ, hãy kiểm tra xem nó có đúng package dal không

public class DashboardDAO extends DBContext {

    // 1. Lấy tổng doanh thu
    public double getTotalRevenue() {
        String sql = "SELECT SUM(total_amount) FROM Orders";
        double total = 0;
        // Kiểm tra xem ông dùng Connection hay getConnection()
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    // 2. Lấy tổng đơn hàng
    public int getTotalOrders() {
        String sql = "SELECT COUNT(*) FROM Orders";
        int count = 0;
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    // 3. Lấy tổng user
    public int getTotalCustomers() {
        String sql = "SELECT COUNT(*) FROM Users WHERE role = 'user'";
        int count = 0;
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
