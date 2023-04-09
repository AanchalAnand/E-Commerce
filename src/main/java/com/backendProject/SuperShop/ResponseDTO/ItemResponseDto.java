package com.backendProject.SuperShop.ResponseDTO;

import com.backendProject.SuperShop.Enum.ProductCategory;
import com.backendProject.SuperShop.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemResponseDto {
    private String name;
    private int price;
    private ProductCategory productCategory;
    private ProductStatus productStatus;

}