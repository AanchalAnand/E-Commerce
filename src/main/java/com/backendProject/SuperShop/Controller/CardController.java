package com.backendProject.SuperShop.Controller;

import com.backendProject.SuperShop.Exception.CustomerNotFoundException;
import com.backendProject.SuperShop.RequestDTO.CardRequestDto;
import com.backendProject.SuperShop.ResponseDTO.CardResponseDto;
import com.backendProject.SuperShop.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;
    @PostMapping("/add")
    public ResponseEntity addCard(@RequestBody CardRequestDto cardRequestDto){
        CardResponseDto cardResponseDto;
        try{
            cardResponseDto=cardService.addCard(cardRequestDto);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(cardResponseDto,HttpStatus.ACCEPTED);
    }
    //remove card
    // remove all card for a partucular customer id;
    //

}