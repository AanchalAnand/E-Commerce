package com.backendProject.SuperShop.ResponseDTO;

import com.backendProject.SuperShop.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDto {
    private String cardNo;
    private CardType cardType;
}