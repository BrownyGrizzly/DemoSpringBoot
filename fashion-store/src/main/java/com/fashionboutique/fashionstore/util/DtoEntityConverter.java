package com.fashionboutique.fashionstore.util;

import java.lang.reflect.Field;

public class DtoEntityConverter {

    public static <T, U> U convertToEntity(T dto, Class<U> entityClass) {
        try {
            U entity = entityClass.newInstance();
            Field[] fields = dto.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(dto);
                Field entityField = entityClass.getDeclaredField(field.getName());
                entityField.setAccessible(true);
                entityField.set(entity, value);
            }
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Error converting to entity", e);
        }
    }

    public static <T, U> T convertToDto(U entity, Class<T> dtoClass) {
        try {
            T dto = dtoClass.newInstance();
            Field[] fields = entity.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(entity);
                Field dtoField = dtoClass.getDeclaredField(field.getName());
                dtoField.setAccessible(true);
                dtoField.set(dto, value);
            }
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Error converting to dto", e);
        }
    }
}
