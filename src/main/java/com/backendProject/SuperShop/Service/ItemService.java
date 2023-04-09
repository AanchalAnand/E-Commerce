package com.backendProject.SuperShop.Service;

import com.backendProject.SuperShop.Convertor.ItemConvertor;
import com.backendProject.SuperShop.Exception.ProductNotFoundException;
import com.backendProject.SuperShop.Model.Item;
import com.backendProject.SuperShop.Model.Product;
import com.backendProject.SuperShop.Repository.ProductRepository;
import com.backendProject.SuperShop.ResponseDTO.ItemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    ProductRepository productRepository;
    public ItemResponseDto viewItem(int productId) throws ProductNotFoundException {
        Product product;
        try{
            product = productRepository.findById(productId).get();
        } catch (Exception e) {
            throw new ProductNotFoundException("Sorry Invalid product Id");
        }
        Item item = Item.builder()
                .requiredQuantity(0)
                .product(product)
                .build();
        product.setItem(item);
        productRepository.save(product);

        ItemResponseDto itemResponseDto = ItemConvertor.ProductToItemResponseDto(product);
        return itemResponseDto;
    }
}