package com.example.java8.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(getRunnalbe("message1"));
        executorService.submit(getRunnalbe("message2"));
        executorService.submit(getRunnalbe("message3"));

        executorService.shutdown();
    }

    private static Runnable getRunnalbe(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
