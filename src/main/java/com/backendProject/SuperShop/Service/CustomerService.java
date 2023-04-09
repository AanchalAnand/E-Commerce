package com.backendProject.SuperShop.Service;

import com.backendProject.SuperShop.Convertor.CustomerConvertor;
import com.backendProject.SuperShop.Model.Cart;
import com.backendProject.SuperShop.Model.Customer;
import com.backendProject.SuperShop.Repository.CustomerRepository;
import com.backendProject.SuperShop.RequestDTO.CustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public String addCustomer(CustomerRequestDto customerRequestDto){
        Customer customer = CustomerConvertor.CustomerRequestDtotoCustomer(customerRequestDto);
        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        customer.setCart(cart);
        customerRepository.save(customer);
        return "Congrats !!! Welcome to Apni Dukaan !!!.";
    }
}