<%@ page import="java.util.*, com.ecommerce.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Products</title></head>
<body>
  <h2>Products</h2>
  <table border="1" cellpadding="6">
    <tr><th>ID</th><th>Name</th><th>Price</th></tr>
    <%
      List<Product> products = (List<Product>) request.getAttribute("products");
      if (products != null) {
        for (Product p : products) {
    %>
      <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getPrice() %></td>
      </tr>
      <tr>
  <td><%= p.getId() %></td>
  <td><%= p.getName() %></td>
  <td><%= p.getPrice() %></td>
  <td><a href="<%= request.getContextPath() + "/cart/add?id=" + p.getId() %>">Add to Cart</a></td>
</tr>

      
    <%   }
      } else { %>
      <tr><td colspan="3">No products found</td></tr>
    <% } %>
    
  </table>
  
</body>
</html>
