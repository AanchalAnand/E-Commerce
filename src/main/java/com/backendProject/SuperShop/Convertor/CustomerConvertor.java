package com.backendProject.SuperShop.Convertor;


import com.backendProject.SuperShop.Model.Customer;
import com.backendProject.SuperShop.RequestDTO.CustomerRequestDto;

public class CustomerConvertor {
    public static Customer CustomerRequestDtotoCustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .name(customerRequestDto.getName())
                .age(customerRequestDto.getAge())
                .email(customerRequestDto.getEmail())
                .mobNo(customerRequestDto.getMobNo())
                .build();
    }

}