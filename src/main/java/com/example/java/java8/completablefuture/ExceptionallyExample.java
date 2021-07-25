package com.example.java.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public class ExceptionallyExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if (atomicBoolean.get()) {
                throw new IllegalArgumentException();
            }
            return "Hello";
        }).exceptionally(ex -> {
            return "Error";
        });

        System.out.println(hello.get());

    }
}
