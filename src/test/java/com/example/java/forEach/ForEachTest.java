package com.example.java.forEach;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ForEachTest {

    @Test
    void changeElement(){
        //given
        List<String> list = Arrays.asList("A", "B", "C", "D");
        //when
        list.forEach(l -> list.set(1,"E"));
        //then
        list.stream().forEach(System.out::println);
    }
}
