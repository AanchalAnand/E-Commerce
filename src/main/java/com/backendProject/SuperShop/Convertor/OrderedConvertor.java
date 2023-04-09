package com.backendProject.SuperShop.Convertor;

import com.backendProject.SuperShop.Model.Customer;
import com.backendProject.SuperShop.Model.Ordered;
import com.backendProject.SuperShop.Model.Product;
import com.backendProject.SuperShop.RequestDTO.OrderRequestDto;

public class OrderedConvertor {
    public static Ordered OrderRequestDtoToOrdered(OrderRequestDto orderRequestDto, Product product, Customer customer){
        int totalCost=orderRequestDto.getRequiredQuantity()*product.getPrice();
        int delivary=0;
        if(totalCost<500){
            delivary = 50;
            totalCost+=delivary;
        }
        return Ordered.builder()
                .totalCost(orderRequestDto.getRequiredQuantity()*product.getPrice())
                .deliveryCharge(delivary)
                .customer(customer)
                .build();
    }
}