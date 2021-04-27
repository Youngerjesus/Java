# Java 8 

***

## 목차
[1. 함수형 인터페이와 람다](#함수형-인터페이와-람다) <br/>
[2. 인터페이스의 변화](#인터페이스의-변화)<br/>
[3. Stream](#Stream) <br/>
[4. Optional](#Optional) <br/>
[5. Date와 Time](#Date와-Time) <br/>
[6. CompletableFuture](#CompletableFuture) <br/>

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


  