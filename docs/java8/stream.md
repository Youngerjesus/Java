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

***

#### Stream Example  

[Stream API 실용적인 15가지 예제](./stream-api.md)