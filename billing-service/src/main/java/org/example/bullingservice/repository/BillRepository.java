package com.emsi.bullingservice.repository;

import com.emsi.bullingservice.entites.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
