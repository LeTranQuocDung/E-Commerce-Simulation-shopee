package controller;

import dal.ProductDAO;
import model.Cart;
import model.CartItem;
import model.Product;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Vào trang /cart thì hiện giao diện giỏ hàng
        String action = request.getParameter("action");

        if (action != null && action.equals("delete")) {
            // Xử lý xóa
            int id = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart != null) {
                cart.removeItem(id);
            }
            // Quay lại trang giỏ hàng
            response.sendRedirect("cart");
        } else {
            // Mặc định: Xem giỏ hàng
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý Thêm vào giỏ (Form submit từ trang Detail)
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        // Nếu chưa có giỏ thì tạo mới
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            // Lấy thông tin sản phẩm từ DB
            ProductDAO dao = new ProductDAO();
            Product p = dao.getProductById(id);

            // Tạo item mới và thêm vào giỏ
            CartItem item = new CartItem(p, quantity, p.getPrice());
            cart.addItem(item);

            // Lưu lại vào session
            session.setAttribute("cart", cart);

            // Chuyển hướng đến trang giỏ hàng
          // Lấy tín hiệu action từ form gửi lên
String action = request.getParameter("action");

if ("buynow".equals(action)) {
    // Nếu là mua ngay, chuyển đến trang cart.jsp nhưng kèm theo lệnh tự submit sang checkout
    // Hoặc đơn giản là chuyển hướng đến một trang trung gian
    response.sendRedirect("cart.jsp?checkout=true");
} else {
    String referer = request.getHeader("Referer");
    response.sendRedirect(referer != null ? referer : "home");
}
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("home");
        }
    }
}
