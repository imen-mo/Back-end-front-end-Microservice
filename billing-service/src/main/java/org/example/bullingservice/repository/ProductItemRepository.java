package com.emsi.bullingservice.repository;

import com.emsi.bullingservice.entites.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
