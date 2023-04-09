package com.backendProject.SuperShop.Service;

import com.backendProject.SuperShop.Convertor.ProductConvertor;
import com.backendProject.SuperShop.Enum.ProductCategory;
import com.backendProject.SuperShop.Exception.SellerNotFoundException;
import com.backendProject.SuperShop.Model.Product;
import com.backendProject.SuperShop.Model.Seller;
import com.backendProject.SuperShop.Repository.ProductRepository;
import com.backendProject.SuperShop.Repository.SellerRepository;
import com.backendProject.SuperShop.RequestDTO.ProductRequestDto;
import com.backendProject.SuperShop.ResponseDTO.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SellerRepository sellerRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException{
        Seller seller;
        try {
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        } catch (Exception e) {
            throw new SellerNotFoundException("Invalid Seller Id");
        }
        Product product  = ProductConvertor.ProductRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);
        seller.getProductList().add(product);
        sellerRepository.save(seller);
        ProductResponseDto productResponseDto = ProductConvertor.ProductToProductResponseDto(product);
        productRepository.save(product);
        return productResponseDto;
    }
    public List<ProductResponseDto> getAllProductByCategory(ProductCategory productCategory){
        List<Product> productList = productRepository.findAllByProductCategory(productCategory);
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for(Product product : productList){
            productResponseDtoList.add(ProductConvertor.ProductToProductResponseDto(product));
        }
        return productResponseDtoList;
    }
}