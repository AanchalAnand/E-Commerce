package com.backendProject.SuperShop.Repository;

import com.backendProject.SuperShop.Enum.ProductCategory;
import com.backendProject.SuperShop.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByProductCategory(ProductCategory productCategory);
}