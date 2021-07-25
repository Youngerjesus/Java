package com.example.java.java8.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class AllOfFuturesExample {

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

        CompletableFuture<List<String>> listCompletableFuture = CompletableFuture.allOf(completableFuturesArray)
                .thenApply(v -> {
                    List<String> collect = completableFutures.stream()
                            .map(CompletableFuture::join) // join() 과 get()은 동일하지만 Join()은 uncheckedException 으로 발생시키므로 예외처리를 안해도 된다.
                            .collect(Collectors.toList());
                    return collect;
                });

        List<String> stringList = listCompletableFuture.get();
    }
}
