package com.ecommerce.servlets;

import java.io.IOException;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cart/remove")
public class RemoveFromCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String idStr = req.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            HttpSession session = req.getSession(false);
            if (session != null) {
                @SuppressWarnings("unchecked")
                Map<Integer, ?> cart = (Map<Integer, ?>) session.getAttribute("cart");
                if (cart != null) {
                    cart.remove(id);
                    session.setAttribute("cart", cart);
                }
            }
        }
        
        resp.sendRedirect(req.getContextPath() + "/cart");
    }
}
