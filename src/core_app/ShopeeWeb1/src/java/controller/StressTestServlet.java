package controller;

import dal.StressDAO;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "StressTestServlet", urlPatterns = {"/api/buy"})
public class StressTestServlet extends HttpServlet {

    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StressDAO dao = new StressDAO();
        int productId = 1; 
        if (request.getParameter("reset") != null) {
            dao.resetStock(productId);
            response.getWriter().print("Da reset kho ve 1");
            return;
        }

        // Thực hiện mua hàng
        boolean result = dao.buyProduct(productId);

        if (result) {
            response.getWriter().print("MUA_THANH_CONG");
        } else {
            response.getWriter().print("HET_HANG");
        }
    }
}
