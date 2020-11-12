package com.psawesome.testcodeproject.baseball;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
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
    @CsvSource(value = {""})
    void testBall() {
// TODO 들어있니?

    }

    @Test
    void testStrike() {
//        TODO 일치하니?
    }

    @ParameterizedTest
    @DisplayName("api를 통해 문자(결과)를 받아 출력한다.")
    @MethodSource("getDisplayText")
    void testDisplayInScreen(String answer, String userInput, String expected) {
        final BaseballResponse actual = BaseballApi.call(BaseballRequest.builder()
                .api(BaseballApi.HOW_MUCH_MATCH)
                .info(answer)
                .body(userInput)
                .build());
//        TODO display로 이동
//        System.out.println(userInput);
//        System.out.println(actual.getBody());
        Assertions.assertEquals(expected, actual.getBody());
    }

    static Stream<Arguments> getDisplayText() {
        return Stream.of(
                Arguments.of("732", "132", "1 스트라이크 1볼"),
                Arguments.of("732", "691", ""),
                Arguments.of("732", "437", "2볼")
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
    private String info;
    private String body;
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
//        TODO find match index
//        TODO find contains count
//        TODO make Text???
        return new BaseballResponse("", "1 스트라이크 1볼");
    });

    Function<BaseballRequest, BaseballResponse> userAct;

    BaseballApi(Function<BaseballRequest, BaseballResponse> userAct) {
        this.userAct = userAct;
    }

    public static BaseballResponse call(BaseballRequest request) {
        return BaseballApi.valueOf(request.getApi().name())
                .userAct.apply(request);
    }

    private static String findMatch(String answer, String inputNumbers) {
        return "";
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
