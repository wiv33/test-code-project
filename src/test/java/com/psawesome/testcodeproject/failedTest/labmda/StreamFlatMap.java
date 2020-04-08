package com.psawesome.testcodeproject.failedTest.labmda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * package: com.psawesome.testcodeproject.failedTest.labmda
 * author: PS
 * DATE: 2020-04-06 월요일 22:28
 */
@Slf4j
public class StreamFlatMap {

    @Data
    static class Foo {
        private String name;
        List<Bar> bars = new ArrayList<>();

        public Foo(String name) {
            this.name = name;
        }
    }

    @Data
    @AllArgsConstructor
    static class Bar {
        private String name;
    }

    List<Foo> foos;

    List<MyPerson> myPersonList = Arrays.asList(
            new MyPerson("Natal", 17),
            new MyPerson("PIL", 27),
            new MyPerson("Netty", 17),
            new MyPerson("Raina", 28));

    @BeforeEach
    void setUp() {
        foos = new ArrayList<>();
    }

    @Test
    void testCreateStream() {

        //create foos
        IntStream.range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));

        foos.forEach(f -> IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.getName()))));

        foos.parallelStream()
                .flatMap(f -> f.bars.stream())
                .forEach(b -> log.info(b.getName()));
    }

    @Test
    void testCreateStreamPipeLine() {
        IntStream.range(1, 4)
//                .parallel()
                .mapToObj(i -> {
                    log.info("check info root mapToObj: {}", i);
                    return new Foo("Foo" + i);
                })
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> {
                            log.info("check info peek.mapToObj => {}", i);
                            return new Bar("Bar " + i + " <- " + f.getName());
                        })
                        .forEach(e -> {
                            log.info("check info peek.forEach => {}", e.toString());
                            f.getBars().add(e);
                        }))
                .flatMap(f -> {
                    log.info("check Info flatMap: {}", f.getBars());
                    return f.getBars().stream();
                })
                .forEach(b -> log.info(b.getName()));

    }

    @Test
    void testStreamPeek() {
        List<String> collect = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> log.info("Filtered value: {}", e))
                .map(String::toUpperCase)
                .peek(e -> log.info("Mapped value: {}", e))
                .collect(Collectors.toList());

        System.out.println("collect = " + collect);
    }

    @Test
    void testReduce() {
        myPersonList.stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
                .ifPresent(o -> {
                    log.info(o.toString());
                    Assertions.assertEquals(new MyPerson("Raina", 28), o);
                });
    }

    @Test
    void testReduceTwoArgs() {
        MyPerson actual = myPersonList.stream()
                .reduce(new MyPerson("AM", 0), (((myPerson, myPerson2) -> {
                    log.info("person Hash : {}, name: {}", myPerson.hashCode(), myPerson.getName());
                    myPerson.setAge(myPerson.getAge() + myPerson2.getAge());
                    myPerson.setName(myPerson.getName() + "_" + myPerson2.getName());
                    return myPerson;
                })));
        MyPerson expected = new MyPerson("AM_Natal_PIL_Netty_Raina", 89);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testReduceCombiner() {
        myPersonList.parallelStream()
                .reduce(0, (sum, p) -> {
                    log.info("\nacc: sum={}, parseon={}", sum, p.getName());
                    return sum + p.getAge();
                }, (s1, s2) -> {
                    log.info("\ncombiner: s1={}, s2={}", s1, s2);
                    return s1 + s2;
                });
    }
}
