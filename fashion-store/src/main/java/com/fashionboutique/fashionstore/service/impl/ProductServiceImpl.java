package com.fashionboutique.fashionstore.service.impl;

import com.fashionboutique.fashionstore.config.ProductRowMapper;
import com.fashionboutique.fashionstore.dto.ProductDTO;
import com.fashionboutique.fashionstore.mapper.ProductMapper;
import com.fashionboutique.fashionstore.model.Category;
import com.fashionboutique.fashionstore.model.Product;
import com.fashionboutique.fashionstore.repository.CategoryRepository;
import com.fashionboutique.fashionstore.repository.ProductRepository;
import com.fashionboutique.fashionstore.service.ProductService;
import com.fashionboutique.fashionstore.specification.ProductSpecifications;
import com.fashionboutique.fashionstore.util.DtoEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private JdbcTemplate productJdbcTemplate;

    @Override
    public List<Product> getAllProducts() {
        String sql = "select * from product";
        return productJdbcTemplate.query(sql, new ProductRowMapper());
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, ProductDTO updatedProductDto) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            Product updatedProduct = DtoEntityConverter.convertToEntity(updatedProductDto, Product.class);
            updatedProduct.setId(existingProduct.getId());
            Category category = categoryRepository.findById(updatedProductDto.getCategoryId()).orElse(null);
            if (category != null) {
                updatedProduct.setCategory(category);
            }
            productRepository.save(updatedProduct);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> searchProducts(String categoryName, Double minPrice) {
        Specification<Product> spec = Specification.where(ProductSpecifications.hasCategory(categoryName))
                .and(ProductSpecifications.hasPriceGreaterThan(minPrice));
        return productRepository.findAll(spec);
    }

    @Override
    public Page<Product> getProductsByCategoryId(Long categoryId, Pageable pageable) {
        return productRepository.findByCategoryId(categoryId, pageable);
    }
}
