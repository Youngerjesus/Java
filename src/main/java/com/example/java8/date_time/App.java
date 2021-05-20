package com.example.java8.date_time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class App {

    public static void main(String[] args) throws InterruptedException {
        // 자바에서 기존에 제공하는
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat();

        System.out.println("============ Start Mutable Date Test ============");
        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);

        Thread.sleep(3000);
        Date newDate = new Date();
        date.setTime(newDate.getTime());

        System.out.println(newDate);
        System.out.println(newDate.getTime());

        System.out.println("============ End Mutable Date Test ============");
    }
}
