## Nest Based Access Control

Java 11 이전에 다음과 같은 Outer-Inner 클래스 구조에서 Inner 클래스가 Outer 클래스의 private 
메소드를 호출하기 위해선 Bridge Method 가 필요했다.

```java
public class Outer {

    public void outerPublic() {
    }

    private void outerPrivate() {
    }

    class Inner {

        public void innerPublic(Outer ob) {
            Method method = ob.getClass().getDeclaredMethod("outerPrivate");
            method.invoke(ob);
        }
    }
}
```

그리고 이런 구조에서 Java 11 이전에는 Inner 클래스에서 리플렉션으로 Outer 메소드를 호출 할 때 private 인 경우에는
Exception 이 발생했다.  

하지만 Java 11 에서는 Nested 관계에선 access 가 가능하게 되었다. 