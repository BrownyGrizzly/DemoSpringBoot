package com.fashionboutique.fashionstore.service;

import com.fashionboutique.fashionstore.dto.CategoryDTO;
import com.fashionboutique.fashionstore.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    void addCategory(CategoryDTO categoryDTO);
    void updateCategory(Long id, CategoryDTO categoryDTO);
    void deleteCategory(Long id);
}
