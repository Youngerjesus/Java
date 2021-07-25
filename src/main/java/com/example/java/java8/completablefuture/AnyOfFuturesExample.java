package com.example.java.java8.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AnyOfFuturesExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello");
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World");
            return "World";
        });

        List<CompletableFuture<String>> completableFutures = Arrays.asList(hello, world);
        CompletableFuture[] completableFuturesArray = completableFutures.toArray(new CompletableFuture[completableFutures.size()]);

        CompletableFuture<Void> future = CompletableFuture.anyOf(completableFuturesArray)
                .thenAccept(System.out::println);


    }
}
