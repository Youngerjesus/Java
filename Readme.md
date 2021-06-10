# Java

***

## 목차
[1. 함수형 인터페이와 람다](#함수형-인터페이와-람다) <br/>
[2. 인터페이스의 변화](#인터페이스의-변화)<br/>
[3. Stream](#Stream) <br/>
[4. Optional](#Optional) <br/>
[5. Date와 Time](#Date와-Time) <br/>
[6. CompletableFuture](#CompletableFuture) <br/>

***

## Stream 

스트림은 연속된 데이터들을 처리하기 위한 오퍼레이션의 모음 이라고 생각하면 좋다. 

스트림 특징은 다음과 같다. 

- 기본적으로 Functional 하게 처리하므로 데이터 소스를 변경시키지 않는다. 

- 스트림으로 처리하는 데이터는 오직 한번만 처리한다.

- 스트림의 중개 오퍼레이션들은 기본적으로 Lazy 하다. (스트림의 오퍼레이션은 다수의 중계 오퍼레이션과 한개의 종료 오퍼레이션으로 구성된다.) 

- 스트림을 이용하면 쉽게 병렬처리를 할 수 있다.  

- 중개 오퍼레이션에 대해 조금 더 알아보자면 Stream 을 처리하고 난 후 Stream 을 리턴한다. 예로 (filter, map, limit, skip, sorted 등이 있다.)

- 종료 오퍼레이션은 Stream 을 리턴하지 않고 처리를 완료시킨 후 다른 타입으로 리턴한다. 예로 (collect, allMatch, count, forEach, min, max 등이 있다.)

#### Non-Terminal Operations
- filter()

- map()

- distinct()

- sorted()

- peek()

#### Terminal Operations

- anyMatch()

- allMatch()

- collect()

- count()

- findFirst()

- min()

- max()

- sum()

- average()


[Stream API 실용적인 15가지 예제](docs/stream-api.md)

*** 

## Optional

Optional 을 이용해서 NullPointException 이 발생하는 것을 막을 수 있다.

Optional 을 리턴 타입으로만 쓰는게 권장 사항이다. 

Optional 을 리턴하기로 했으면 절대 null 을 리턴하지말자. 이 메소드를 쓰는 클라이언트를 고려하자. 클라이언트는 반환된 Optional 이 null 이 아니고 Optional 이 가진 API 를 쓸 것이므로   

메소드 매개변수로도 쓸 수는 있다. 하지만 이 경우 Optional 을 쓰는 이유가 없다. 기존 Null 처리 방식이랑 똑같기도하고 매개변수 자체가 Null 이 들어올수도 있으니까.

Map 의 Key 타입으로도 Optional 을 쓰면 안된다. 근본적인 Map 과 매칭이 안된다. Key는 Null이 되면 안되므로. 

필드로도 Optional 을 쓰면 안된다. 필드 값이 있을수도 있고 없을수도 있다라는 건 말이 안된다. 도메인 설계의 문제다.         

기본 자바 Primitive 타입에도 Optional 을 쓸 수 있는데 OptionalInt 같은걸 이용해서 IntStream 으로 값을 처리할때 받을 수 있다. 

Optional 을 또 다른 Optional 이나 Collection 을 감싸지 말자. 이것들은 비어있음을 나타낼 수 있는 클래스들이다. 즉 중복이다.   

Optional 이 제공하는 기본 API 특징은 다음과 같다. 

- 값을 꺼내야 하는 경우에 Optional.orElse(method1()) 메소드를 사용할 수 있는데 이는 값이 없는 경우애도 method1 이 무조건 실행되는 성능상에 단점이 있다.  

- Optional.orElseGet(method1()) 을 이용하면 값이 있는 경우에는 method1() 을 이용하지 않는다.  

- Optional.orElseThrow(() -> throw new Exception() 을 통해서 값이 없는 경우에는 예외를 던지도록 할 수 있다. 

- Optional.filter() 를 통해서 원하는 조건의 값을 가져올 수 있다.

- Optional.Map() 을 통해서 특정 매핑되는 부분의 값만 가지고 올 수 있다. 

- Optional.Map() 을 통해서 가지오 오는 값이 Optional 이라면 Optional 중첩 구조로 가지고온다. 이런 경우에 flatMap() 을 이용하면 간단히 가져올 수 있다. 

***

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

***

## CompletableFuture

#### 자바 Cuncurrent 프로그래밍 
- 동시에 여러가지 작업을 할 수 있는 프로그래밍
- `main` 에서 실행되는 스레드는 메인 스레드 여기서 여러가지 스레드를 만들 수 있다. 
  - `Thread` 를 직접 상속시켜서 만들 수도 있고 `Runnable` 을 이용해서 만들 수 있다. 


#### `Thread`의 기본 기능은 알고 있어야 한다.
* `sleep` 을 통해서 스레드를 재워서 다른 스레드에게 우선권을 줄 수 있다. 
* 만약 스레드가 자고 있다면 `interrupt` 를 통해서 다른 스레드를 꺠울 수 있다. 그리고 자고 있던 스레드는 `InterruptedException` 예외를 받아서 처리하도록 할 수 있다.
  * 뭐 처리는 계속 작업을 이어가던지 아니면 스레드를 종료시키던지 이런 것들이 있을 수 있겠지.
  
  
#### Executor 사용하기 
* 스레드를 만들고 관리하는 작업을 애플리케이션에서 분리하고 그런 기능을 Executor에게 위임한다.
* 무슨 일을 해야하는지만 알려준다.  
* `ExecutorService` 를 상속받은 `ScheduledExecutorService` 도 있는데 이건 특정시간 이후에 실행을 하던가 주기적으로 실행을 하도록 할 수 있다.
* `ExecutorService` 는 작업을 완료한 후에 새로운 작업이 실행될 때까지 계속해서 기다리는 역할을 한다. 
* `ExecutorService` 안에는 `BlockingQUeue` 가 있는데 해야 할 작업들을 여기에다가 쌓아둔다.
* 또 `ForkJoinPool` 이라고 해서 멀티 프로세싱에 유용한 풀이 이싿. 

#### Executor vs ExecutorService
* `ExecutorService` 가 확장판이다 `ExecutorSerivce` 의 `submit` 메소드의 기능은 `Executor` 의 `execute` 기능에다가 `Future` 를 리턴하는 기능까지 합쳐졌다. 

#### Callable 사용하기
* `Runnable` 과 같지만 리턴을 할 수 있다라는 특징이 있다. 
* `Future` 의 `get` 메소드 전까지는 블로킹 되지않고 실행된다. 
* `Future.isDone()` 메소드를 통해 결과가 나왔는지 안나왔는지 확인이 가능하다.   
* `Future.cancle()` 메소드를 통해 작업을 취소할 수 있다. 이 값에 `true` 로 설정한다면 `interrupt` 를 걸고 `false` 로 설정한다면 기다리지만 값을 가져오지는 못한다. 그리고 `Future.isDone()` 메소드는 `true` 가 된다. 
* `executorService.invokeAll()` 메소드를 통해 모든 `Callable` 작업을 한번에 넘기는게 가능하다. 이때 나오는 결과 값은 `Future` 의 리스트들이다. 
  * 이때 먼저 끝나는 애는 마지막에 끝나는 애까지 작업이 완료될 때까지 기다린다. 
  * 하나만 완료되면 끝나는 일은 `executorService.invokeAny()` 메소드다.
  
  
#### CompletableFuture 사용하기
* 자바에서 비동기 프로그래밍을 가능하게 하는 인터페이스 
  * `Future` 를 사용해서도 어느정도 가능했지만 힘든 일이 많다.
* 이름 자체가 외부에서 Complete를 실행시킬 수 있다.  
* 비동기 실행을 `CompletableFuture.runAsync()` 메소드를 통해서 할 수 있다. 만약 결과 값이 나와야하는 실행이라면 `CompletableFuture.supplyAsync()` 메소드를 통해서 가능하다
* 비동기 콜백을 받고 싶다면 `CompletableFuture.thenRun(), CompletableFuture.thenApply(), CompletableFuture.thenAccept()` 를 통해서 가능하다.
* `CompletableFuture` 은 내부적으로 Fork/Join 풀을 가지고있다. 이게 싫으면 실행할 때 `ExecutorSerivce` 를 매개변수로 넘겨줘서 그 스레드 풀을 사용하도록 하는 것도 가능하다.  
* 그리고 비동기 콜백들 실행도 다른 풀을 쓰고 싶다면 `thenRunAsync, thenApplyAsync, thenAcceptAsync` 메소드를 사용하면 된다. 
* `CompletableFuture.thenCompose()` 메소드를 통해서 비동기 실행을 합칠 수 있다. 
* `CompletableFuture.thenCombine()` 메소드를 통해서 병렬적인 실행을 합칠 수 있다. ByFunction을 이용한 것처럼 둘 다 결과가 다 나와야지 리턴이 되는. 
* `CompletableFuture.thenCombine()` 메소드는 두 개 일때만 합칠 수 있는거다. 여러개의 실행을 합치고 싶다면 `CompletableFuture.allOf()` 메소드를 통해서 가능하다.
* `CompletableFuture.anyOf()` 메소드를 통해서 여러개의 병렬 실행중 먼저 결과가 오는 것들을 처리하도록 할 수 있다.
* `CompletableFuture.exceptionally()` 메소드를 통해서 스레드 실행 흐름 중 발생한 예외를 받을 수 있다. 
* `CompletableFuture.handle()` 메소드를 통해서 정상적인 흐름의 실행과 예외의 실행을 둘 다 받을 수 있고 실행할 수 있다. 

  
#### Future로는 힘든 일들
* 예외 처리용 API를 제공하지 않고
* `Future` 를 외부에서 완료시킬 수 없다. 취소하거나 `Future.get()` 메소드에 타임아웃을 설정할 수 있다. 
* 블로킹 코드를 사용하는 방법밖에 없다. 콜백을 사용할 수 없다. 
* 여러 `Future` 를 조합할 수 없다. 하나의 `Future` 가 끝난 다음 다음 `Future` 를 실행시킨다던지. 


  
