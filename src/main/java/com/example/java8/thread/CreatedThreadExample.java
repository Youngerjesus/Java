package com.example.java8.thread;

public class CreatedThreadExample {
    public static void main(String[] args) {
        MyThread extendsThread = new MyThread();
        Thread runnableThread = new Thread(() -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread " + Thread.currentThread().getName());
        });

        runnableThread.start();
        extendsThread.start();

        System.out.println("Hello");
    }

    // Thread를 만드는 첫번째 방벙
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName());
        }
    }
}