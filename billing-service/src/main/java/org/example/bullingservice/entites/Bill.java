package com.emsi.bullingservice.entites;

import jakarta.persistence.*;
import lombok.*;
import com.emsi.bullingservice.model.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder

public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private Date billingDate;
   private long CustomerId;
   @OneToMany(mappedBy = "bill")
   private List<ProductItem> productItems = new ArrayList<>();
   @Transient private Customer customer;

}
