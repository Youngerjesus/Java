package com.example.java8.date_time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DurationTest {

    public static void main(String[] args) {
        Instant now = Instant.now();
        Instant nowPlusTen = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, nowPlusTen);
        System.out.println(between);

        LocalDateTime before = LocalDateTime.of(12, Month.DECEMBER, 5, 0, 0);
        LocalDateTime after = LocalDateTime.of(12, Month.DECEMBER, 5, 0, 0);

        System.out.println(after.compareTo(before));
    }
}
