package com.psawesome.testcodeproject.baseball;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScreenTest {

    BaseballScreen realBaseballScreen;

    @BeforeEach
    void setUp() {
        realBaseballScreen = new BaseballScreen();
    }

    @Test
    void testWelcomeToBaseball() {
        assertEquals("Y", this.expectedUserInput("Y"));
        assertEquals("1", this.expectedUserInput("1"));
    }

    @Test
    @DisplayName("실제 게임 시작 시 정답을 생성한다.")
    void testExistsAnswerAtStartBaseball() {
        Assertions.assertNotNull(realBaseballScreen);
        assertEquals(3, realBaseballScreen.getAnswer().length());
    }


    @ParameterizedTest
    @MethodSource("getDisplayText")
    void testStrike(String answer, String inputText, String expectedStrike) {
        final String strike = BaseballApi.makeStrike(answer, inputText, 0, 0);
        Assertions.assertEquals(expectedStrike, strike);
    }

    @ParameterizedTest
    @MethodSource("getDisplayText")
    void testBall(String answer, String inputText, String expectedStrike, String expectedBall) {
        assertEquals(expectedBall, BaseballApi.makeBall(answer, inputText, 0, 0));
    }

    @ParameterizedTest
    @DisplayName("api를 통해 문자(결과)를 받아 출력한다.")
    @MethodSource("getDisplayText")
    void testDisplayInScreen(String answer, String inputText,
                             String expectedStrike,
                             String expectedBall,
                             String expected) {
        final BaseballResponse actual = BaseballApi.call(BaseballRequest.builder()
                .api(BaseballApi.HOW_MUCH_MATCH)
                .info(answer)
                .body(inputText)
                .build());
        System.out.println(inputText);
        System.out.println(actual.getBody());
        Assertions.assertEquals(expected, actual.getBody());
    }

    static Stream<Arguments> getDisplayText() {
        return Stream.of(
                Arguments.of("732", "132", "2 스트라이크", "", "2 스트라이크"),
                Arguments.of("732", "691", "", "", ""),
                Arguments.of("732", "437", "1 스트라이크", "1볼", "1 스트라이크 1볼"),
                Arguments.of("732", "731", "2 스트라이크", "", "2 스트라이크"),
                Arguments.of("732", "732", "", "", "3개의 숫자를 모두 맞히셨습니다. 게임 종료")
        );
    }

    @Test
    @DisplayName("")
    @Disabled
    void testCallHowMuchMatchInApi() {
        assertTrue(realBaseballScreen.howMuchMatch("123").matches("\\d+"));
    }

    String expectedUserInput(String input) {
        Scanner sc = new Scanner(input);
        final String s = sc.nextLine();
        sc.close();
        return s;
    }
}

@Data
@RequiredArgsConstructor
class BaseballResponse {
    private final String info;
    private final String body;
}

@Getter
@Builder
class BaseballRequest {
    private final BaseballApi api;
    private final String info;
    private final String body;
}

enum BaseballApi {
    ANSWER(req -> {
        final int RESULT_LENGTH = 3;
        Set<String> result = new HashSet<>();

        do {
            final int x = ThreadLocalRandom.current().nextInt(1, 9);
            result.add(String.valueOf(x));
        } while (result.size() < RESULT_LENGTH);

        return new BaseballResponse("answer", result.toString().replaceAll("[^\\d]", ""));
    }),
    HOW_MUCH_MATCH(req -> {
        final String answer = req.getInfo();
        final String inputNumbers = req.getBody();
        if (makeOut(answer, inputNumbers)) {
            return new BaseballResponse("end", "3개의 숫자를 모두 맞히셨습니다. 게임 종료");
        }
        final String strike = makeStrike(answer, inputNumbers, 0, 0);
        final String ball = makeBall(answer, inputNumbers, 0, 0);
        final String result = makeResult(strike, ball);
        return new BaseballResponse("ing", result);
    });

    private static boolean makeOut(String answer, String inputNumbers) {
        return answer.equals(inputNumbers);
    }

    private static String makeResult(String strike, String ball) {
        if (strike.isEmpty() || ball.isEmpty()) {
            return String.format("%s%s", strike, ball);
        }
        return String.format("%s %s", strike, ball);
    }

    Function<BaseballRequest, BaseballResponse> userAct;

    BaseballApi(Function<BaseballRequest, BaseballResponse> userAct) {
        this.userAct = userAct;
    }

    public static BaseballResponse call(BaseballRequest request) {
        return BaseballApi.valueOf(request.getApi().name())
                .userAct.apply(request);
    }

    public static String makeStrike(String answer, String inputNumbers, int idx, int strike) {
        strike = increaseIfEqualStrike(answer, inputNumbers, idx, strike);
        if (idx > answer.length() - 2) {
            return concatText(strike, " 스트라이크");
        }
        return makeStrike(answer, inputNumbers, idx + 1, strike);
    }

    private static int increaseIfEqualStrike(String answer, String inputNumbers, int idx, int strike) {
        if (answer.charAt(idx) == inputNumbers.charAt(idx)) {
            return strike + 1;
        }
        return strike;
    }

    public static String makeBall(String answer, String inputNumbers, int idx, int ball) {
        ball = increaseIfEqualBall(answer, inputNumbers, idx, ball);
        if (idx > answer.length() - 2) {
            return concatText(ball, "볼");
        }
        return makeBall(answer, inputNumbers, idx + 1, ball);
    }

    private static int increaseIfEqualBall(String answer, String inputNumbers, int idx, int ball) {
        if (answer.charAt(idx) != inputNumbers.charAt(idx) &&
                answer.contains(String.valueOf(inputNumbers.charAt(idx)))) {
            return ball + 1;
        }
        return ball;
    }

    public static String concatText(int count, String text) {
//        return count == 0 ? "" : String.format("%d%s", count, text);
        if (count == 0) {
            return "";
        }
        return String.format("%d%s", count, text);
    }

}

@Data
class BaseballScreen {
    private Scanner sc;
    private final String answer;

    public BaseballScreen() {
        this.answer = BaseballApi.call(
                BaseballRequest.builder()
                        .api(BaseballApi.ANSWER)
                        .build())
                .getBody();
        this.ready();
    }

    public void ready() {
        System.out.print("숫자를 입력하세요: ");
    }

    public void submitDisplay(String text) {
        System.out.println(text);
    }

    public String howMuchMatch(String input) {
        final BaseballResponse result = BaseballApi.call(BaseballRequest.builder()
                .api(BaseballApi.HOW_MUCH_MATCH)
                .info(this.answer)
                .body(input)
                .build());
        return result.getBody();
    }

}
