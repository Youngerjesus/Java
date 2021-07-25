package com.example.java.java8.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.schedule(() -> System.out.println("Hello"), 5, TimeUnit.SECONDS);
        scheduledExecutorService1.scheduleAtFixedRate(() -> System.out.println("Hello2"), 1, 2, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
    }
}
