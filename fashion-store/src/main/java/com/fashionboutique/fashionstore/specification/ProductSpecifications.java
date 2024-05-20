package com.fashionboutique.fashionstore.specification;

import org.springframework.data.jpa.domain.Specification;
import com.fashionboutique.fashionstore.model.Product;

public class ProductSpecifications {

    public static Specification<Product> hasCategory(String categoryName) {
        return (root, query, cb) -> cb.equal(root.get("category").get("name"), categoryName);
    }

    public static Specification<Product> hasPriceGreaterThan(Double price) {
        return (root, query, cb) -> cb.greaterThan(root.get("price"), price);
    }
}
