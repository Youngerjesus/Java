package com.example.java.java11;

import lombok.NonNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LocalVariableForLambdaTest {

    @Test
    void test(){
        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String resultString = sampleList.stream()
                .map((@NonNull var x) -> x.toUpperCase())
                .collect(Collectors.joining(", "));

        System.out.println(resultString);
    }
}