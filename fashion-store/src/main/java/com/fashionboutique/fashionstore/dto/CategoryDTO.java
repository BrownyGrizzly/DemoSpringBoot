package com.fashionboutique.fashionstore.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDTO {
    @NotBlank
    private String name;
}
