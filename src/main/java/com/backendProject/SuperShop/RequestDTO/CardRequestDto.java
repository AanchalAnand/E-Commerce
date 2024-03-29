package com.backendProject.SuperShop.RequestDTO;


import com.backendProject.SuperShop.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardRequestDto {
    private int customerId;
    private String cardNo;
    private int cvv;
    private CardType cardType;
}