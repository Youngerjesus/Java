package com.example.java8.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {

        // ExecutorService를 만드는 팩토리에서 SingleExecutorService를 만드는 과정
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
        });

        // graceful Shutdown
        executorService.shutdown();
    }
}
