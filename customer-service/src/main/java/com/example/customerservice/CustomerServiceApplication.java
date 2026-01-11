package com.emsi.customerservice;

import com.emsi.customerservice.config.CustomerConfigParams;
import com.emsi.customerservice.entites.Customer;
import com.emsi.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {

            customerRepository.save(
                    Customer.builder()
                            .firstName("jhon")
                            .lastName("Enset")
                            .email("contact@enset-media.ma")
                            .build()
            );

            customerRepository.save(
                    Customer.builder()
                            .firstName("philip")
                            .lastName("FSTM")
                            .email("contact@fstm.ma")
                            .build()
            );

            customerRepository.save(
                    Customer.builder()
                            .firstName("TOM")
                            .lastName("ENSAM")
                            .email("contact@ensam.ma")
                            .build()
            );

            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
