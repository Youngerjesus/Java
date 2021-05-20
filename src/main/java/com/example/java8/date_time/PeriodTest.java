package com.example.java8.date_time;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthDay = LocalDate.of(2021, Month.MAY, 16);

        Period period = Period.between(today, thisYearBirthDay);
        System.out.println(period.getDays());
        System.out.println(period.get(ChronoUnit.DAYS));

        Period until = today.until(thisYearBirthDay);
        System.out.println(until);

    }
}
