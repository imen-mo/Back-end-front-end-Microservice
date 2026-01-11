package com.emsi.inventoryservice.repository;

import com.emsi.inventoryservice.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository  extends JpaRepository <Product,String>{
    List<Product> id(Long id);
}
