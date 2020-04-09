package com.psawesome.testcodeproject.failedTest.labmda;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * package: com.psawesome.testcodeproject.failedTest.labmda
 * author: PS
 * DATE: 2020-04-02 목요일 23:06
 */
public class CollectStreamExam {
    List<MyPerson> myPersonList = Arrays.asList(
            new MyPerson("Natal", 17),
            new MyPerson("PIL", 27),
            new MyPerson("Netty", 17),
            new MyPerson("Raina", 28));

    @Test
    @DisplayName("FIND PIL")
    void testFindPil() {
        List<MyPerson> expected = Arrays.asList(new MyPerson("PIL", 27));

        List<MyPerson> p1 = myPersonList.parallelStream()
                .filter(p -> p.getName().startsWith("P"))
                .collect(Collectors.toList());

        assertAll("Find Persons",
                () -> assertArrayEquals(expected.toArray(), p1.toArray()),
                () -> assertEquals(1, p1.size()),
                () -> assertEquals("PIL", p1.get(0).getName()),
                () -> assertEquals(27, p1.get(0).getAge())
        );
    }

    @Test
    @DisplayName("20세 이하")
    void testFindAge() {
        List<MyPerson> expected1 = Arrays.asList(new MyPerson("Natal", 17), new MyPerson("Netty", 17));
        int expectedSize = 2;

        List<MyPerson> age17 = myPersonList.stream()
                .filter(s -> s.getAge() < 20)
                .collect(Collectors.toList());


        assertAll("20세 이하",
                () -> assertArrayEquals(expected1.toArray(), age17.toArray()),
                () -> assertEquals(expectedSize, age17.size())
        );
    }

    @Test
    void testGrouping() {
        Map<Integer, List<MyPerson>> collect = myPersonList.parallelStream()
                .collect(Collectors.groupingBy(MyPerson::getAge));

        collect.forEach((age, p) -> System.out.format("age %s : %s\n", age, p));
    }
}
@Data
@AllArgsConstructor
class MyPerson {
    String name;
    int age;

}
