package com.example.java.java8.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MultiCallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> hello = () -> {
            Thread.sleep(5000);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(2000);
            return "java";
        };

        Callable<String> spring = () -> {
            Thread.sleep(1000);
            return "spring";
        };

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, spring));

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        String result = executorService.invokeAny(Arrays.asList(hello, java, spring));
        System.out.println(result);
    }
}
