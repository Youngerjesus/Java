package com.example.java8.optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    List<OnlineClass> springClasses = new ArrayList<>();
    @BeforeEach
    void setUp(){
        springClasses.add(new OnlineClass(1L, "spring boot", true));
        springClasses.add(new OnlineClass(2L, "spring boot rest api", true));
        springClasses.add(new OnlineClass(3L, "spring boot mvc", false));
    }

    @Test
    @DisplayName("Optional.of() Test")
    void testOf(){
        OnlineClass onlineClass = new OnlineClass(1L,"spring data jpa", true);
        Optional<OnlineClass> optionalOnlineClass = Optional.of(onlineClass);
        OnlineClass onlineClass1 = optionalOnlineClass.get();
        System.out.println(onlineClass1);
    }

    @Test
    @DisplayName("Optional.isPresent() Test")
    void testIsPresent() {
        Optional<OnlineClass> first = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        if (first.isPresent()) {
            OnlineClass spring = first.get();
            assertEquals(1, spring.getId());
        }
    }

    @Test
    @DisplayName("Optional.ifPresent() Test")
    void testIfPresent() {
        Optional<OnlineClass> first = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        first.ifPresent(oc -> assertEquals(1, oc.getId()));
    }

    @Test
    @DisplayName("Optional.orElse() Test")
    void testOrElse() {
        Optional<OnlineClass> first = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        OnlineClass spring = first.orElse(createNewSpringClass());
        assertEquals(1, spring.getId());
    }

    private OnlineClass createNewSpringClass() {
        System.out.println("craeteNewSpringClass");
        return new OnlineClass(10L, "spring core", true);
    }

    @Test
    @DisplayName("Optional.orElseGet() Test")
    void testOrElseGet(){
        Optional<OnlineClass> first = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        OnlineClass springClass = first.orElseGet(this::createNewSpringClass);
        assertEquals(1, springClass.getId());
    }

    @Test
    @DisplayName("Optional.isEmpty() Test")
    void testIsEmpty(){
        Optional<OnlineClass> first = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        assertEquals(true, first.isEmpty());
    }

    @Test
    @DisplayName("Optional.orElseThrow() Test")
    void testOrElseThrow(){
        Optional<OnlineClass> first = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        OnlineClass jpaClass = first.orElseThrow(RuntimeException::new);
        System.out.println(jpaClass);
    }

    @Test
    @DisplayName("Optional.filter() Test")
    void testFilter(){
        Optional<OnlineClass> first = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findAny();

        Optional<OnlineClass> filterClass = first.filter(oc -> oc.getId() > 100);

        assertEquals(true, filterClass.isEmpty());
    }

    @Test
    @DisplayName(("Optional.map() Test"))
    void testMap(){
        Optional<OnlineClass> first = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findAny();

        Optional<Long> id = first.map(OnlineClass::getId);
    }

    @Test
    @DisplayName("Optional.flatMap() Test")
    void testFlatMap(){
        Optional<OnlineClass> first = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findAny();

        Optional<Progress> progress = first.flatMap(OnlineClass::getProgress);
    }
}