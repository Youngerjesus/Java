package com.example.java.java11;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class NewStringMethodsTest {

    @Test
    void string_lines_method_test(){
        //given
        String multiLineString = "Baeldung helps \n \n developers \n explore Java.";
        //when
        multiLineString.lines() // lines 메소드는 \n 을 기준으로 잘린다.
                .filter(line -> !line.isBlank()) // isBlank() 메소드는 빈 문자열인지 체크하는 메소드다.
                .forEach(System.out::println);
        //then
    }
    
    @Test
    void string_strip_method_test(){
        //given
        String string = " asfjaslfjasl gjlaskgjasklj gjasdklgjaskl ";
        String stripString = string.strip();
        //when
        System.out.println(string);
        System.out.println(stripString);
        //then
    }

    @Test
    void string_trip_method_test(){
        //given
        String string = " asfjaslfjasl gjlaskgjasklj gjasdklgjaskl ";
        String trimString = string.trim();
        //when
        System.out.println(string);
        System.out.println(trimString);
        //then
    }
    
    @Test
    void string_repeat_method_test(){
        //given
        String string = "test";
        //when
        String repeat = string.repeat(3);
        //then
        System.out.println(repeat);
    }

}