package com.example.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public class HandleExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if (atomicBoolean.get()) {
                throw new IllegalArgumentException();
            }
            return "Hello";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return "Error";
            } else {
                return result;
            }
        });

        System.out.println(hello.get());

    }
}
