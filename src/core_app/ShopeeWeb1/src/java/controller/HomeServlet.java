package controller;

import dal.ProductDAO;
import model.ProductDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home", "/search"})
public class HomeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      
        String txtSearch = request.getParameter("txt"); 
        if (txtSearch == null) {
       
        }

      
        ProductDAO dao = new ProductDAO();
        List<ProductDTO> list = dao.searchProducts(txtSearch);

     
        request.setAttribute("products", list);
        request.setAttribute("txtS", txtSearch); 

        request.getRequestDispatcher("shopee_home.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}