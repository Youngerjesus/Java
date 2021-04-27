package com.example.java8.completablefuture;

import java.util.concurrent.*;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();

        future.complete("Test");

        System.out.println(future.get());


        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Hello 1" + Thread.currentThread().getName());
        });

        voidCompletableFuture.get();

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello 2" + Thread.currentThread().getName());
            return "Hello2";
        });

        stringCompletableFuture.get();

        CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello 3" + Thread.currentThread().getName());
            return "Hello3";
        }).thenApply(s -> {
            System.out.println("Hello 3 " + s.toUpperCase() + " then Apply " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).get();

        CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello 4" + Thread.currentThread().getName());
            return "Hello4";
        }).thenAccept(s -> {
            System.out.println("Hello 4 " + s.toUpperCase() + " then Apply " + Thread.currentThread().getName());
        }).get();
    }
}
