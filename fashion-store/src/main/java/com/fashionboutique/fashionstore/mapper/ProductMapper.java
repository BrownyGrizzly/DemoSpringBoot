package com.fashionboutique.fashionstore.mapper;

import com.fashionboutique.fashionstore.dto.ProductDTO;
import com.fashionboutique.fashionstore.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);
}
