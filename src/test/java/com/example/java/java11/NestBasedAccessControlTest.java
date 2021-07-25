package com.example.java.java11;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NestBasedAccessControlTest {

    @Test
    void test(){
        //given
        NestBasedAccessControl outer = new NestBasedAccessControl();
        //when
        Class<?>[] nestMembers = outer.getClass().getNestMembers();
        Arrays.stream(nestMembers)
                .forEach(c -> {
                    try {
                        if (!c.getName().equals("com.example.java.java11.NestBasedAccessControl")) {
                            Method innerPublic = c.getDeclaredMethod("innerPublic");
                            System.out.println(innerPublic);
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                });
        //then
    }
}