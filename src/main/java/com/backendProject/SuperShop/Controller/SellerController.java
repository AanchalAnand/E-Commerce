package com.backendProject.SuperShop.Controller;

import com.backendProject.SuperShop.Model.Seller;
import com.backendProject.SuperShop.RequestDTO.SellerRequestDto;
import com.backendProject.SuperShop.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;
    @PostMapping("/add")
    public String addSeller(@RequestBody SellerRequestDto sellerRequestDto){
        return sellerService.addSeller(sellerRequestDto);
    }
    //get all seller
    @GetMapping("/getallSeller")
    public List<Seller> getAllSeller(){
        return sellerService.getAllSeller();
    }
    //get a seller by pan card

    //get seller of a paru


}