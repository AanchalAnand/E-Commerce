package com.backendProject.SuperShop.Service;

import com.backendProject.SuperShop.Convertor.SellerConvertor;
import com.backendProject.SuperShop.Model.Seller;
import com.backendProject.SuperShop.Repository.SellerRepository;
import com.backendProject.SuperShop.RequestDTO.SellerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;
    public String addSeller(SellerRequestDto sellerRequestDto){
        Seller seller = SellerConvertor.SellerRequestDtoToSeller(sellerRequestDto);
        sellerRepository.save(seller);
        return "Congrats! Now You Can Sell On Apna-Dukaan !!!";
    }
    public List<Seller> getAllSeller(){
        List<Seller> sellers = sellerRepository.findAll();
        return sellers;
    }
}