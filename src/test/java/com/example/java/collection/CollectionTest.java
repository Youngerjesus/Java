package com.example.java.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {

    @Test
    void 읽기전용_컬렉션_수정_테스트(){
        //given
        final List<Integer> testList = new ArrayList<>();
        //when
        testList.add(5);
        testList.add(6);
        testList.add(7);
        testList.add(8);
        testList.add(9);
        //then
        System.out.println(testList);
    }

    @Test
    void 읽기전용_컬렉션_수정_테스트2(){
        //given
        final List<Integer> testList = new ArrayList<>();
        //when
        testList.add(5);
        testList.add(6);
        testList.add(7);
        testList.add(8);
        testList.add(9);

        testList.remove(0);
        //then
        System.out.println(testList);
    }
}
