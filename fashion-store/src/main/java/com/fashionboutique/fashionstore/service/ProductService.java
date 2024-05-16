package com.fashionboutique.fashionstore.service;

import com.fashionboutique.fashionstore.dto.ProductDTO;
import com.fashionboutique.fashionstore.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void addProduct(ProductDTO productDTO);
    void updateProduct(Long id, ProductDTO updatedProductDto);
    void deleteProduct(Long id);
    List<Product> searchProducts(Long categoryId, Double priceMin);
    Page<Product> getProductsByCategoryId(Long categoryId, Pageable pageable);
}
