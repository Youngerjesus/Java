package com.example.java8.date_time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeFormatting {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(MMddyyyy)); // DateTimeFormatter 를 이용해서 원하는 형식으로 출력이 가능하다.

        DateTimeFormatter mmddyyyy = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(now.format(mmddyyyy));

        LocalDate parse = LocalDate.parse("05/20/2021", MMddyyyy);
        System.out.println(parse);

    }
}
