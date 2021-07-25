## Predicate Not Method

Predicate 의 static 메소드로 not 메소드가 추가됐다. 

다음과 같이 사용하는게 가능하다. 

```java
@Test
void Predicate_Not_Test(){
    //given
    List<String> sampleList = Arrays.asList("String1", "\n", "\n\n", "test", "java", "Kotlin");
    //when
    List<String> collect = sampleList
            .stream()
            .filter(Predicate.not(String::isBlank))
            .collect(Collectors.toList());
    //then
    collect.forEach(System.out::println);
}
``` 