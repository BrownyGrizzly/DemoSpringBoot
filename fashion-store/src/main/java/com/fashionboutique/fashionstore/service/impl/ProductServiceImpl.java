package com.fashionboutique.fashionstore.service.impl;

import com.fashionboutique.fashionstore.dto.ProductDTO;
import com.fashionboutique.fashionstore.model.Product;
import com.fashionboutique.fashionstore.repository.ProductRepository;
import com.fashionboutique.fashionstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product updatedProduct) {
        productRepository.save(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product convertToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setColor(productDTO.getColor());
        product.setSize(productDTO.getSize());
        product.setPrice(productDTO.getPrice());
        return product;
    }
}