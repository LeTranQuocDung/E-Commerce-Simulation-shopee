package controller;

import dal.UserDAO;
import model.User;
import java.io.IOException;
import java.security.MessageDigest;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

   
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
        
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        
     
        String passHash = getMd5(pass);

       
        UserDAO dao = new UserDAO();
        User user = dao.login(email, passHash); 

        if (user != null) {
           
            HttpSession session = request.getSession();
            
           
            session.setAttribute("account", user);
            
         
            session.setMaxInactiveInterval(30 * 60);

            response.sendRedirect("home");
        } else {
            
            request.setAttribute("mess", "Sai email hoặc mật khẩu!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}