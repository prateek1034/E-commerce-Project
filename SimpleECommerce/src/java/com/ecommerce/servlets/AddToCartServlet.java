package com.ecommerce.servlets;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.CartItem;
import com.ecommerce.model.Product;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cart/add")
public class AddToCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String idStr = req.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            HttpSession session = req.getSession();
            
            @SuppressWarnings("unchecked")
            Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
            if (cart == null) {
                cart = new HashMap<>();
            }
            
            ProductDAO dao = new ProductDAO();
            Product product = dao.getProductById(id);
            
            if (product != null) {
                if (cart.containsKey(id)) {
                    CartItem item = cart.get(id);
                    item.setQuantity(item.getQuantity() + 1);
                } else {
                    cart.put(id, new CartItem(product, 1));
                }
            }
            
            session.setAttribute("cart", cart);
        }
        
        resp.sendRedirect(req.getContextPath() + "/cart");
    }
}
