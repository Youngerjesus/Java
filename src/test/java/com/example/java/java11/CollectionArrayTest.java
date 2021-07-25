package com.example.java.java11;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionArrayTest {

    @Test
    void collection_to_an_Array(){
        //given
        List<String> stringList = Arrays.asList("String1", "String2", "String3");
        //when
        String[] strings = stringList.toArray(String[]::new);
        //then
        System.out.println(strings[0]);
        System.out.println(strings[1]);
        System.out.println(strings[2]);
    }

}