## Collection to an Array

Java 11 에서 java.util.Collection 클래스에 기본 메소드로 Array 로 변환시켜주는 메소드가 등장했다. 

다음과 같이 사용하는게 가능하다. 

```java
@Test
void collection_to_an_Array(){
    //given
    List<String> stringList = Arrays.asList("String1", "String2", "String3");
    //when
    String[] strings = stringList.toArray(String[]::new);
    //then
    System.out.println(strings[0]);
    System.out.println(strings[1]);
    System.out.println(strings[2]);
}
```