package com.example.java.java11;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PredicateNotTest {

    @Test
    void Predicate_Not_Test(){
        //given
        List<String> sampleList = Arrays.asList("String1", "\n", "\n\n", "test", "java", "Kotlin");
        //when
        List<String> collect = sampleList
                .stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        //then
        collect.forEach(System.out::println);
    }

}