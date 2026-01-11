package com.emsi.bullingservice;

import com.emsi.bullingservice.entites.Bill;
import com.emsi.bullingservice.entites.ProductItem;
import com.emsi.bullingservice.feign.CustomerRestClient;
import com.emsi.bullingservice.feign.ProductRestClient;
import com.emsi.bullingservice.model.Customer;
import com.emsi.bullingservice.model.Product;
import com.emsi.bullingservice.repository.BillRepository;
import com.emsi.bullingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BullingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BullingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient) {


        return args -> {
            Collection<Customer> customers = customerRestClient.findAllCustomer().getContent();
            Collection<Product> products = productRestClient.getAllProducts().getContent();
            customers.forEach(customer -> {
                Bill bill = Bill.builder()
                        .billingDate(new Date())
                        .CustomerId(customer.getId())
                        .build();
                billRepository.save(bill);
                products.forEach(product -> {
                    ProductItem productItem = ProductItem.builder()
                            .bill(bill)
                            .productId(product.getId())
                            .Quantity(1+new Random().nextInt(10))
                            .unitPrice(product.getPrice())
                            .build();
                    productItemRepository.save(productItem);
                });
            });
        };
    }
}
