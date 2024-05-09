package com.fashionboutique.fashionstore.service;

import com.fashionboutique.fashionstore.dto.ProductDTO;
import com.fashionboutique.fashionstore.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void addProduct(ProductDTO productDTO);
    void updateProduct(Product updatedProduct);
    void deleteProduct(Long id);
    Product convertToEntity(ProductDTO productDTO);
}
