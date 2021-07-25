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
