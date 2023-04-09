package com.backendProject.SuperShop.Service;
import com.backendProject.SuperShop.Convertor.CardConvertor;
import com.backendProject.SuperShop.Exception.CustomerNotFoundException;
import com.backendProject.SuperShop.Model.Card;
import com.backendProject.SuperShop.Model.Customer;
import com.backendProject.SuperShop.Repository.CustomerRepository;
import com.backendProject.SuperShop.RequestDTO.CardRequestDto;
import com.backendProject.SuperShop.ResponseDTO.CardDto;
import com.backendProject.SuperShop.ResponseDTO.CardResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CustomerRepository customerRepository;
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {
        Customer customer;
        try {
            customer = customerRepository.findById(cardRequestDto.getCustomerId()).get();
        }
        catch (Exception e){
            throw new CustomerNotFoundException("Invalid Customer Id");
        }
        Card card = CardConvertor.CardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);
        customer.getCardList().add(card);
        customerRepository.save(customer);
        // prepare respnse dto for return
        CardResponseDto cardResponseDto = CardConvertor.CardToCardResponseDto(card);
        cardResponseDto.setName(customer.getName());
        // make CardDto
        List<CardDto> cardDtoList = new ArrayList<>();
        for(Card card1 : customer.getCardList()){
            CardDto cardDto = new CardDto();
            cardDto.setCardNo(card.getCardNo());
            cardDto.setCardType(card.getCardType());
            cardDtoList.add(cardDto);
        }
        cardResponseDto.setCardDtos(cardDtoList);
        return cardResponseDto;
    }
}