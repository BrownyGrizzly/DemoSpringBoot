package com.fashionboutique.fashionstore.config;

import com.fashionboutique.fashionstore.model.Product;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("name"));
        product.setColor(rs.getString("color"));
        product.setSize(rs.getString("size"));
        product.setPrice(rs.getDouble("price"));
        return product;
    }
}

