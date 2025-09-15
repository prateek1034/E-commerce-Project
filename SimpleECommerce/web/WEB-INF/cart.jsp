<%@ page import="java.util.*, com.ecommerce.model.CartItem" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Your Cart</title></head>
<body>
  <h2>Your Shopping Cart</h2>
  <a href="${pageContext.request.contextPath}/products">Continue Shopping</a>
  <br><br>
  <%
    List<CartItem> items = (List<CartItem>) request.getAttribute("cartItems");
    double total = (Double) (request.getAttribute("grandTotal") != null ? request.getAttribute("grandTotal") : 0.0);
    if (items != null && !items.isEmpty()) {
  %>
    <table border="1" cellpadding="6">
      <tr><th>Name</th><th>Price</th><th>Qty</th><th>Total</th><th>Action</th></tr>
      <%
        for (CartItem item : items) {
      %>
      <tr>
        <td><%= item.getProduct().getName() %></td>
        <td><%= item.getProduct().getPrice() %></td>
        <td><%= item.getQuantity() %></td>
        <td><%= item.getTotal() %></td>
        <td><a href="<%= request.getContextPath() + "/cart/remove?id=" + item.getProduct().getId() %>">Remove</a></td>
      </tr>
      <% } %>
      <tr>
        <td colspan="3"><b>Grand Total</b></td>
        <td colspan="2"><b><%= total %></b></td>
      </tr>
    </table>
  <% } else { %>
    <p>Your cart is empty.</p>
  <% } %>
</body>
</html>
