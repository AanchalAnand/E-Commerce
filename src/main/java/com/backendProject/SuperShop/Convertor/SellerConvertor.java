package com.backendProject.SuperShop.Convertor;

import com.backendProject.SuperShop.Model.Seller;
import com.backendProject.SuperShop.RequestDTO.SellerRequestDto;

public class SellerConvertor {
    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){
        return Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobNo(sellerRequestDto.getMobNo())
                .panNo(sellerRequestDto.getPanNo())
                .build();
    }
}