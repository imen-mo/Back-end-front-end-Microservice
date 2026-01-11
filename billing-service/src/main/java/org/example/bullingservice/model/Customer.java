package com.emsi.bullingservice.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Customer {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
