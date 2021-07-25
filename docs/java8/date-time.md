## Date와 Time

기존의 Date는 setTime() 메소드로 인해 시간을 변경하는게 가능했다. 변경이 가능하다는 말은 멀티스레드 환경에서 안전하지 않다. 즉 thread-safe 하지 않다. 

GregorianCalendar 같은 경우에는 type-safe 하지 않다. month로 받는 입력값ㅇ느 int로 받을 수 있는데 이는 음수도 들어갈 수 있다는 의미니까. 그리고 Month도 0 값이 1월을 뜻한다.
(타입 세이프 하게 할려면 Month 에는 Month 라는 enum 타입을 받도록 설곅가 되어 있어야 한다.)
(Calendar 도 Immutable 하지는 않다.)

자바8에서는 Immutable 하게 만들기 위해서 기존의 값을 변경시키지 않고 새로운 값이 나오도록 설계했다. 

자바 8에서 제공하는 주요 API 특징은 다음과 같다. 

- 기계용 시간(machine time)과 휴먼용 시간(human time) 으로 나뉜다. 

- 기게용 시간은 EPOCK(1970년 1월 1일 0분 0초) 부터 현재까지의 타임스탬프를 말한다.

- 타임스탬프는 Instant를 사용한다.

- 특정 날짜(LocalDate), 시간(LocalTime), 일시(LocalDateTime) 을 사용하는게 가능하다. 

- 기간을 표현할 땐 Duration(시간 기반)과 Period(날짜 기반)을 사용하는게 가능하다. 

- DateTimeFormatter 를 사용해서 일시를 특정한 문자열로 포매팅할 수 있다.    

#### 지금 이 순간을 기계 시간으로 표현하는 방법
- Instant.now(): 현재 UTC (GMT)를 리턴한다.

#### 인류용 일시를 표현하는 방법
- LocalDateTime.now(): 현재 시스템 Zone에 해당하는(로컬) 일시를 리턴한다.
- LocalDateTime.of(int, Month, int, int, int, int): 로컬의 특정 일시를 리턴한다. 
- ZonedDateTime.of(int, Month, int, int, int, int, ZoneId): 특정 Zone의 특정 일시를 리턴한다.

#### 기간을 표현하는 방법
- Period / Duration . beteen() 
- Period 는 사람용 Duration 은 기계용으로 생각하면 편하다. 

#### 포매팅
- DateTimeFormatter.ofPattern("MM/d/yyyy") 을 이용해서 원하는 형태로 포매팅을 할 수 있다.

#### 레거시 API 지원
- GregorianCalendar와 Date 타입의 인스턴스를 Instant나 ZonedDateTime으로 변환이 가능하다. 