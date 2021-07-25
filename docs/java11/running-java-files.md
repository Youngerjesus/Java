## Running Java Files 

Java 11 부터는 이제 javac 로 명시적인 소스파일을 컴파일 하지 않아도 java 명령어로 
실행하는게 가능하다.

즉 다음과 같이 사용하지 않아도 된다.

이렇게 실행하면 JVM 은 소스 파일을 컴파일해서 메모리에 올리고 main() 함수를 찾아서 실행시킨다. 
```
$ javac HelloWorld.java
$ java HelloWorld 

// 이렇게 사용하는게 가능하다
$ java HelloWorld.java
```  

