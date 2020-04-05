package com.psawesome.testcodeproject.failedTest.labmda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
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

    @Test
    @DisplayName("P로 시작하는 객체의 집합")
    void testCollectorsToSet() {
        Set<MyPerson> p = myPersonList.stream()
                .filter(m -> m.getName().startsWith("P"))
                .collect(Collectors.toSet());

        assertEquals("[MyPerson{name='PIL', age=27}]", p.toString());
    }

    @Test
    @DisplayName("원소들의 평균 집계 만들기")
    void testAverageGroup() {
        Double average = myPersonList.parallelStream()
                .collect(Collectors.averagingDouble(MyPerson::getAge));

        assertEquals(22.25, average);
    }

    @Test
    void testAverage() {
        System.out.println( (17 * 2 + 27 + 28.0) / 4.0);
    }

    @Test
    @DisplayName("빌트 - 인 요약 통계 객체")
    void testCollectorsSummarizingDouble() {
        DoubleSummaryStatistics actual = myPersonList
                .parallelStream()
                .collect(Collectors.summarizingDouble(MyPerson::getAge));

        String expected = "DoubleSummaryStatistics{count=4, sum=89.000000, min=17.000000, average=22.250000, max=28.000000}";
        assertEquals(expected, actual.toString());
    }

    @Test
    @DisplayName("myPerson의 이름을 문자열로 join")
    void testCollectorsJoining() {
        String actual = myPersonList.parallelStream()
                .map(MyPerson::getName)
                .collect(Collectors.joining(" and ", "In the world ", "..."));

        String expected = "In the world Natal and PIL and Netty and Raina...";
        assertEquals(expected, actual);
    }

    @Test
    void testCollectorsToMap() {
        Map<Integer, String> actual = myPersonList
                .stream()
                .collect(Collectors.toMap(
                        MyPerson::getAge,
                        MyPerson::getName,
                        (n1, n2) -> n1 + "," + n2
                ));
//        마지막 BinaryOperator 가 없을 경우 중복 키 처리를 할 수 없다.
//        java.lang.IllegalStateException: Duplicate key 17 (attempted merging values Natal and Netty)

        String expected = "{17=Natal,Netty, 27=PIL, 28=Raina}";
        assertEquals(expected, actual.toString());
    }
}

class MyPerson {
    String name;
    int age;

    public MyPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public MyPerson setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public MyPerson setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "MyPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyPerson myPerson = (MyPerson) o;

        if (age != myPerson.age) return false;
        return Objects.equals(name, myPerson.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
