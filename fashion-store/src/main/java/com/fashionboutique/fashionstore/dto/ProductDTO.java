package com.fashionboutique.fashionstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;


@Data
public class ProductDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Color is mandatory")
    private String color;

    @NotBlank(message = "Size is mandatory")
    private String size;

    @NotNull(message = "Price is mandatory")
    @PositiveOrZero(message = "Price must be greater than or equal to 0")
    private Double price;
    private Long categoryId;
}
