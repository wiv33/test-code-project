package com.psawesome.testcodeproject.failedTest.labmda;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * package: com.psawesome.testcodeproject.failedTest.labmda
 * author: PS
 * DATE: 2020-04-02 목요일 22:53
 */
@Slf4j
public class StreamExam {

    @Test
    void testStartCollection() {
        Arrays.asList("a", "2", "c", "4", "e")
                .parallelStream()
                .findFirst()
                .ifPresent(a -> Assertions.assertEquals("a", a));
    }

    @Test
    void testStartStream() {
        Stream.of("1", "b", "3", "d", "5")
                .findFirst()
                .ifPresent(s -> Assertions.assertEquals("1", s));
    }

    @Test
    void testIntStream() {
        String expected = "my 1 : my 2 : my 3 : my 4 : my 5 : my 6 : my 7 : my 8 : my 9 : my 10 : my 11";
        IntStream.range(1, 12)
                .mapToObj(n -> "my " + n)
                .reduce((acc, s) -> acc + " : " + s)
                .ifPresent(result -> Assertions.assertEquals(expected, result));
    }

    @Test
    @DisplayName("[Seed 와] [hasNext 의 predicate], [UnaryOperator 의 next] 관계를 이해한다.\n 해당 스트림은 0만 내보낸다.")
    void testStreamIterate() {
        Stream.iterate(0, (i) -> i % 7 == 0, (i) -> i++)
                .limit(10)
                .forEach(v -> Assertions.assertEquals(0, v));
        /*
                0
                0
                0
                0
                0
                0
                0
                0
                0
                0
                0
         */
    }

    @Test
    @DisplayName("특정 문자가 포함되어 있는 UUID 출력")
    void testStreamIterate_two() {
        StopWatch sw = new StopWatch();
        sw.start();
        Stream.iterate(0, i -> i + 1)
                .parallel()
                .map(i -> UUID.randomUUID() + "_" + i )
                .filter(s -> {
                    boolean b = s.contains("p") || s.contains("s") || s.contains("k");
                    System.out.format("{%s} -> {%b}\n",s , b);
                    return b;
                })
                .findFirst()
                .ifPresent(r -> log.info("result {} ", r));
        sw.stop();
        log.info("total Seconds : {}", sw.getTotalTimeSeconds());
    }

    @Test
    void testStreamBuilder() {
        IntStream.iterate(0, a -> a + 1)
                .mapToObj(v -> new MyPerson(UUID.randomUUID().toString(), v))
                .map(myPerson -> {
                    System.out.println("name = " + myPerson.getName());
                    return Arrays.asList(myPerson.getName().split("-"));
                })
                .flatMap(s -> s.stream().map(str -> {
                    String[] a = str.split("");
                    Arrays.sort(a);
                    return String.join("", a);
                }).sorted().reduce((a, b)-> b + "-" + a).stream())
                .limit(1000)
        .forEach(System.out::println);
    }

    @Test
    void testParallelStream() {
        Arrays.asList("a1", "a2", "a3", "b1", "b2", "b4", "c7", "c3", "c9")
        .parallelStream()
                .filter(v -> {log.info("in filter"); return true;})
                .map(s -> {log.info("in Map"); return s.toUpperCase();})
                .sorted((o1, o2) -> {
                    System.out.format("sort: %s.compareTo(%s) [%s] : result[%s]\n", o1, o2, Thread.currentThread().getName(), o1.compareTo(o2));
                    return o1.compareTo(o2);
                })
                .forEach(v -> log.info("in last forEach"));

    }
}