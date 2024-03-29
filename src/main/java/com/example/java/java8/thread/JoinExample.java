package com.example.java.java8.thread;

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {

            System.out.println("Thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                // Interrupted Exception 발생하면 종료 되도록 하는 법
                System.out.println("exit");
                return;
            }
        });
        thread.start();

        System.out.println("Hello " + Thread.currentThread().getName());
        thread.join();
        System.out.println(thread.getName() + "is Finished");
    }
}
