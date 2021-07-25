package com.example.java.java8.date_time;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class HumanTime {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today); // LocalDateTime 은 현재 나의 Zone 을 참고해서 출력해준다. 그러므로 서버가 미국에 있다면 미국 시간을 기준으로 출력해준다.

        LocalDateTime birthDay = LocalDateTime.of(1995, Month.MARCH, 15, 0, 0, 0);
        System.out.println(birthDay);

        ZonedDateTime nowInAmerica = ZonedDateTime.now(ZoneId.of("America/Chicago"));
        System.out.println(nowInAmerica); // 특정 Zone 의 시간응 알고싶으 경우에 ZonedDateTime 을 이용하면 된다.
    }
}
