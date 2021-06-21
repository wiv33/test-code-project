package com.psawesome.testcodeproject.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * package: com.psawesome.testcodeproject.programmers
 * author: PS
 * DATE: 2021-06-19 토요일 18:28
 */
class DartGame {

    static Stream<Arguments> result() {
        return Stream.of(
                Arguments.of("1S2D*3T", 37),
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
        final List<String> score = Arrays.stream(dart.split("[SDT]")).filter(f -> f.matches(".*[0-9]{1,2}")).collect(Collectors.toList());


        int listSize = score.size();
        for (int i = 0; i < listSize; i++) {
            String options = option[i + 1];
            final String s = score.get(i);

            scoreList.add(new Score(s, options));
            if (i > 0 && options.contains("*")) {
                scoreList.get(i - 1).nextInject();
            }
        }

        Integer result = scoreList.stream()
                                  .map(Score::result)
                                  .reduce((acc, s) -> acc += s)
                                  .orElseThrow(RuntimeException::new);

        Assertions.assertEquals(expected, result);
    }
}

class Score {
    private final String area;
    private final String award;
    private final Map<String, Integer> areaMap = Map.of("S", 1,
                                                        "D", 2,
                                                        "T", 3);
    private final Map<String, Integer> awardMap = Map.of("*", 2,
                                                         "#", -1);
    private int score;

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
        this.score = (int) Math.pow(this.score, this.areaMap.get(area));
    }

    int result() {
        return this.score;
    }

}
