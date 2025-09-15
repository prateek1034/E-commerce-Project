package com.ecommerce.servlets;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.Product;
import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.getAllProducts();

        request.setAttribute("products", products);
        RequestDispatcher rd = request.getRequestDispatcher("products.jsp");
        rd.forward(request, response);
    }
}
