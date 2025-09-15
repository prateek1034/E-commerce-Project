package com.ecommerce.servlets;

import com.ecommerce.model.CartItem;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        @SuppressWarnings("unchecked")
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        
        List<CartItem> items = new ArrayList<>();
        double total = 0;
        
        if (cart != null) {
            items.addAll(cart.values());
            for (CartItem item : items) {
                total += item.getTotal();
            }
        }
        
        req.setAttribute("cartItems", items);
        req.setAttribute("grandTotal", total);
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }
}
