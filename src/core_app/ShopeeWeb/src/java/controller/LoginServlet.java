package controller;

import dal.UserDAO;
import model.User;
import java.io.IOException;
import java.security.MessageDigest; // Thêm import băm mật khẩu
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    // BẮT BUỘC: Hàm băm MD5 phải y chang bên RegisterServlet
    private String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            java.math.BigInteger no = new java.math.BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Lấy đúng tên biến từ login.jsp gửi về
        String u = request.getParameter("user");      // Email khách nhập
        String pRaw = request.getParameter("password"); // Mật khẩu thô (123...)

        if (u == null || pRaw == null) {
            request.setAttribute("error", "Vui lòng nhập đầy đủ!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // 2. Băm mật khẩu người dùng vừa nhập ra MD5 để so sánh với DB
        String passHash = getMd5(pRaw);

        UserDAO dao = new UserDAO();
        // 3. Gọi hàm login (Đảm bảo bên UserDAO hàm này tên là login)
        User account = dao.login(u, passHash);

        if (account != null) {
            // Thành công -> Lưu Session
            HttpSession session = request.getSession();
            session.setAttribute("account", account);

            // Chuyển hướng về trang chủ
            response.sendRedirect("home");
        } else {
            // Thất bại -> Báo lỗi
            request.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
