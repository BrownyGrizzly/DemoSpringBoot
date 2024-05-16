package com.fashionboutique.fashionstore.specification;

import org.springframework.data.jpa.domain.Specification;
import com.fashionboutique.fashionstore.model.Product;

public class ProductSpecifications {

    public static Specification<Product> hasCategory(Long categoryId) {
        return (root, query, cb) -> cb.equal(root.get("category").get("id"), categoryId);
    }

    public static Specification<Product> hasPriceGreaterThan(Double price) {
        return (root, query, cb) -> cb.greaterThan(root.get("price"), price);
    }
}
