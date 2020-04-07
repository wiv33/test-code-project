package com.psawesome.testcodeproject.failedTest.labmda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
}
