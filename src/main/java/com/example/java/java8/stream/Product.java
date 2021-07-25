package com.example.java.java8.stream;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class Product {
    private Long id;

    private String name;
    private String category;

    private Set<Order> orders;
}
