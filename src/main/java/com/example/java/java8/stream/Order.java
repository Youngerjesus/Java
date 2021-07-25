package com.example.java.java8.stream;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
public class Order {
    private Long id;

    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    private String status;

    private Customer customer;
    Set<Product> products;
}
