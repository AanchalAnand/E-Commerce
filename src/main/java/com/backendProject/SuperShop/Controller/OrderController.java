package com.backendProject.SuperShop.Controller;

import com.backendProject.SuperShop.Exception.CustomerNotFoundException;
import com.backendProject.SuperShop.Exception.InsufficientQuantity;
import com.backendProject.SuperShop.Exception.ProductNotFoundException;
import com.backendProject.SuperShop.RequestDTO.OrderRequestDto;
import com.backendProject.SuperShop.ResponseDTO.OrderResponseDto;
import com.backendProject.SuperShop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @PostMapping("/place")
    public ResponseEntity placeOrder(@RequestBody OrderRequestDto orderRequestDto){
        OrderResponseDto orderResponseDto;
        try {
            orderResponseDto = orderService.placeOrder(orderRequestDto);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (ProductNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (InsufficientQuantity e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(orderResponseDto, HttpStatus.BAD_REQUEST);
    }
}