package com.backendProject.SuperShop.Convertor;

import com.backendProject.SuperShop.Model.Product;
import com.backendProject.SuperShop.ResponseDTO.ItemResponseDto;

public class ItemConvertor {

    public static ItemResponseDto ProductToItemResponseDto(Product product){
        return ItemResponseDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .productCategory(product.getProductCategory())
                .productStatus(product.getProductStatus())
                .build();
    }
}