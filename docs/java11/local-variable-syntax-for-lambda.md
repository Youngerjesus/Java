## Local-Variable Syntax for Lambda

Java 10 에 local variable (var) 타입 추론 기능이 들어왔지만 이를 lambda 에서
사용하는게 불가능했다. 

즉 자바 10에서는 다음과 같은 예제를 지원하지 않았다.

```java
(var s1, var s2) -> s1 + s2
```  

다음과 같이 사용하는게 가능하다. 

```java
@Test
void test(){
    List<String> sampleList = Arrays.asList("Java", "Kotlin");
    String resultString = sampleList.stream()
            .map((@NonNull var x) -> x.toUpperCase())
            .collect(Collectors.joining(", "));

    System.out.println(resultString);
}
```

