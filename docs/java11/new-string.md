## New String Methods

Java 11 에는 다음과 같은 String 메소드가 들어왔다.

- isBlank() 

  - 문자열이 비어있는지 알려주는 메소드다. 

- lines()

  - 문자열을 \n 을 기준으로 자르는 메소드다. 

- strip()

  - trim() 메소드가 Unicode 에서 인식을 잘 하지 못하는 문제를 해결하기 위해 나오는 메소드다.
  trim() 메소드 같은 경우는 ASCII code 나 ISO 같은 언어에서만 잘 작동하는 한계가 있다. 

- stripLeading()

  - strip() 메소드를 문자열 앞부분에만 적용하는 메소드다. 

- stripTrailing()

  - strip() 메소드를 문자열 뒷부분에만 적용하는 메소드다.

- repeat()

  - 기존의 String 문자를 반복해서 새로운 문자를 만들때 사용하는 메소드다. 
  
다음과 같이 사용하는게 가능하다. 

```java
@Test
void string_lines_method_test(){
    //given
    String multiLineString = "Baeldung helps \n \n developers \n explore Java.";
    //when
    multiLineString.lines() // lines 메소드는 \n 을 기준으로 잘린다.
            .filter(line -> !line.isBlank()) // isBlank() 메소드는 빈 문자열인지 체크하는 메소드다.
            .forEach(System.out::println);
    //then
}

@Test
void string_strip_method_test(){
    //given
    String string = " asfjaslfjasl gjlaskgjasklj gjasdklgjaskl ";
    String stripString = string.strip();
    //when
    System.out.println(string);
    System.out.println(stripString);
    //then
}

@Test
void string_trip_method_test(){
    //given
    String string = " asfjaslfjasl gjlaskgjasklj gjasdklgjaskl ";
    String trimString = string.trim();
    //when
    System.out.println(string);
    System.out.println(trimString);
    //then
}

@Test
void string_repeat_method_test(){
    //given
    String string = "test";
    //when
    String repeat = string.repeat(3);
    //then
    System.out.println(repeat);
}
```
