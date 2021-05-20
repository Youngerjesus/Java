package com.example.java8.date_time;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DurationTest {

    public static void main(String[] args) {
        Instant now = Instant.now();
        Instant nowPlusTen = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, nowPlusTen);
        System.out.println(between);
    }
}
