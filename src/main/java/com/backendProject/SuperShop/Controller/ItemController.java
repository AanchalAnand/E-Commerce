package com.backendProject.SuperShop.Controller;

import com.backendProject.SuperShop.Exception.ProductNotFoundException;
import com.backendProject.SuperShop.Model.Product;
import com.backendProject.SuperShop.ResponseDTO.ItemResponseDto;
import com.backendProject.SuperShop.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;
    @GetMapping("/view/{productId}")
    public ResponseEntity viewItem(@PathVariable("productId") int productId){
        ItemResponseDto itemResponseDto;
        try {
            itemResponseDto = itemService.viewItem(productId);

        } catch (ProductNotFoundException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity(itemResponseDto,HttpStatus.ACCEPTED);
    }

}