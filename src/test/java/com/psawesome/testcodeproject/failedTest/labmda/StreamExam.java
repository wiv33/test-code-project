package com.psawesome.testcodeproject.failedTest.labmda;

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
    void testStreamIterate_two() {
        StopWatch sw = new StopWatch();
        sw.start();
        Stream.iterate(0, i -> i++)
                .map(i -> UUID.randomUUID() + "_" + i )
                .filter(s -> s.contains("p") || s.contains("s"))
                .findFirst()
                .ifPresent(r -> System.out.println("result = " + r));
        sw.stop();
        System.out.println(sw.getTotalTimeSeconds());
    }

    @Test
    void testStreamBuilder() {
        Stream.builder();
    }
}
