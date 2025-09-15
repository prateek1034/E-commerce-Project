package com.ecommerce.dao;

import com.ecommerce.model.Product;
import java.sql.*;
import java.util.*;

public class ProductDAO {
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT id, name, price FROM products";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                list.add(new Product(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
