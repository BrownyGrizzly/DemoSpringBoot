package com.fashionboutique.fashionstore.service;

import com.fashionboutique.fashionstore.dto.ProductDTO;
import com.fashionboutique.fashionstore.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void addProduct(ProductDTO productDTO);
    void updateProduct(Long id, ProductDTO updatedProductDto);
    void deleteProduct(Long id);
}
