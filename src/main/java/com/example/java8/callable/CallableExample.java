package com.example.java8.callable;

import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Hello";
            }
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println("#### Hello1 Started");
        System.out.println(helloFuture.isDone());
        System.out.println(helloFuture.get());
        System.out.println(helloFuture.isDone());
        System.out.println("#### Hello1 Ended");

        System.out.println("#### Hello2 Started");
        Future<String> helloFuture2 = executorService.submit(hello);
        helloFuture2.cancel(true);

        System.out.println("#### Hello2 ended");
        executorService.shutdown();
    }
}
