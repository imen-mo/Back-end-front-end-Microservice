package com.emsi.bullingservice.web;

import com.emsi.bullingservice.entites.Bill;
import com.emsi.bullingservice.entites.ProductItem;
import com.emsi.bullingservice.feign.CustomerRestClient;
import com.emsi.bullingservice.feign.ProductRestClient;
import com.emsi.bullingservice.repository.BillRepository;
import com.emsi.bullingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient  productRestClient;
    @GetMapping("/bills/{id}")
    public Bill getBill(Long id){
        Bill bill  = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        return bill;
    }
}
