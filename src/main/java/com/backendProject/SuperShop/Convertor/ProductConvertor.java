package com.backendProject.SuperShop.Convertor;

import com.backendProject.SuperShop.Enum.ProductStatus;
import com.backendProject.SuperShop.Model.Product;
import com.backendProject.SuperShop.RequestDTO.ProductRequestDto;
import com.backendProject.SuperShop.ResponseDTO.ProductResponseDto;

public class ProductConvertor {
    public static Product ProductRequestDtoToProduct(ProductRequestDto productRequestDto){
        return Product.builder()
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .productStatus(ProductStatus.AVAILABLE)
                .productCategory(productRequestDto.getProductCategory())
                .build();
    }
    public static ProductResponseDto ProductToProductResponseDto(Product product){
        return ProductResponseDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .productStatus(product.getProductStatus())
                .build();
    }
}