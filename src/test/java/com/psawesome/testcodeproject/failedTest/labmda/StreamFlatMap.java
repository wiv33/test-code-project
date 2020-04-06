package com.psawesome.testcodeproject.failedTest.labmda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar("Bar " + i + " <- " + f.getName()))
                        .forEach(f.getBars()::add))
                .flatMap(f -> f.getBars().stream())
                .forEach(b -> log.info(b.getName()));

    }
}
