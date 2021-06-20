package com.psawesome.testcodeproject.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * package: com.psawesome.testcodeproject.programmers
 * author: PS
 * DATE: 2021-06-19 토요일 18:28
 */
public class DartGame {

  static Stream<Arguments> result() {
    return Stream.of(Arguments.of("1S2D*3T", 37),
            Arguments.of("1D2S#10S", 9),
            Arguments.of("1D2S0T", 3),
            Arguments.of("1S*2T*3S", 23),
            Arguments.of("1D#2S*3S", 5),
            Arguments.of("1T2D3D#", -4),
            Arguments.of("1D2S3T*", 59));
  }
  @ParameterizedTest
  @MethodSource("result")
  void testSplit(String dart, int expected) {

    List<Score> scoreList = new ArrayList<>();
    final String[] option = dart.split("\\d{1,2}");
    final String[] score = dart.split("[SDT]");

    boolean eq = option.length == score.length;
    for (int i = 0; i < score.length; i++) {
      final int idx = eq ? i : i + 1;
      String options = option[idx];
      final String s = score[i];
      System.out.println(s + " , " + options);
      scoreList.add(new Score(s, options));
      if (i > 0 && options.contains("*")) {
        scoreList.get(i - 1).nextInject();
      }
    }

    int result = 0;
    for (Score s : scoreList) {
       result += s.result();
    }

    Assertions.assertEquals(expected, result);
  }
}

class Score {
  private int score;
  private final String area;
  private final String award;
  final int MAX_SCORE = 10;

  private final Map<String, Integer> areaMap = Map.of("S", 1,
          "D", 2,
          "T", 3);
  private final Map<String, Integer> awardMap = Map.of("*", 2,
          "#", -1);

  public Score(String score, String option) {
    this.score = Integer.parseInt(score.replaceAll("[^\\d]", ""));
    this.area = option.replaceAll("[^STD]", "");
    this.award = option.replaceAll("[^*#]", "");
    this.area();
    this.award();
  }

  void nextInject() {
    this.score *= 2;
  }

  void award() {
    if ("".equals(award)) {
      return;
    }

    final String[] split = award.split("");
    for (String x : split) {
      this.score *= this.awardMap.get(x);
    }
  }

  void area() {
    System.out.println("before = " + score + ", area = " + area);
    this.score = (int) Math.pow(this.score, this.areaMap.get(area));
    System.out.println("after = " + score);
  }

  int result() {
    return this.score;
  }

}