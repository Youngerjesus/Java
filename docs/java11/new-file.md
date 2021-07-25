## New File Methods

Java 11 에 들어온 파일 관련 메소드는 다음과 같다.

- Files::writeString() : String 클래스를 이용해 파일에 내용을 기입하는 메소드다. 

- Files::readString() : 파일에 있는 내용을 String 으로 읽어오는 메소드다. 

다음과 같이 사용하는게 가능하다. 

```java
@Test
void Files_writeString_Method() throws IOException {
    //given
    Path filePath = Files.writeString(Files.createTempFile(Path.of("demo"), "demo", ".txt"), "Sample String");
    //when
    String fileContent = Files.readString(filePath);
    //then
    assertEquals("Sample String", fileContent);
}
```