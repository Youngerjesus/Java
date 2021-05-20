package com.example.java8.date_time;

import java.time.*;
import java.util.Date;
import java.util.GregorianCalendar;

public class MachineTime {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant); // Instant 는 기준시 UTC 이다. (영국 기준)

        Instant instant1 = Instant.now();
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZonedDateTime zonedDateTime = instant1.atZone(zoneId);
        System.out.println(zonedDateTime); // 나의 시간 기준

        Instant seoulTime = Instant.now(Clock.system(ZoneId.of("Asia/Seoul"))); // 바로 나의 시간 기준으로 알 수 있다.
        System.out.println(seoulTime);

        Date date = new Date();
        Instant instant2 = date.toInstant(); // Date 와 Instance는 호환이 가능하다
        Date newDate = date.from(instant2);

        GregorianCalendar calendar = new GregorianCalendar();
        LocalDateTime localDateTime = calendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // Calendar 도 호환이 가능하다.
        System.out.println(localDateTime);
    }
}
