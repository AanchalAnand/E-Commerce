package com.backendProject.SuperShop.Convertor;

import com.backendProject.SuperShop.Model.Card;
import com.backendProject.SuperShop.RequestDTO.CardRequestDto;
import com.backendProject.SuperShop.ResponseDTO.CardResponseDto;

public class CardConvertor {

    public static Card CardRequestDtoToCard(CardRequestDto cardRequestDto){
        return Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cvv(cardRequestDto.getCvv())
                .cardType(cardRequestDto.getCardType())
                .build();
    }
    public static CardResponseDto CardToCardResponseDto(Card card){
        return CardResponseDto.builder().build();
    }
}