package com.psawesome.testcodeproject.failedTest.labmda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
    void testFindPil() {
        List<MyPerson> expected = Arrays.asList(new MyPerson("PIL", 27));
        List<MyPerson> p1 = myPersonList.parallelStream()
                .filter(p -> p.getName().startsWith("P"))
                .collect(Collectors.toList());

        assertAll("Find PIL",
                () -> assertArrayEquals(expected.toArray(), p1.toArray()));
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
