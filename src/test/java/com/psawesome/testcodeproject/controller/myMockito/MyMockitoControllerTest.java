package com.psawesome.testcodeproject.controller.myMockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.regex.Pattern;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * package: com.psawesome.testcodeproject.controller.myMockito
 * author: PS
 * DATE: 2020-03-24 화요일 22:35
 */

@DisplayName("My special Test")
@SpringBootTest
class MyMockitoControllerTest {

    @InjectMocks
    MyMockitoController myMockitoController;

    MockHttpSession session;
    MockHttpServletRequest request;

    MockMvc mvc;

    @BeforeEach
    void setUp() {
        Assertions.assertNotNull(myMockitoController);

        session = new MockHttpSession();

        request = new MockHttpServletRequest();

        mvc = MockMvcBuilders.standaloneSetup(myMockitoController)
                .build();
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("first annotation displayName")
    void displayNameFirstTest() {

    }

    //    @Test
    @DisplayName("Annotation으로 args 넘기기")
    @ParameterizedTest(name = "세 번의 호출이 될 것이다.")
    @ValueSource(strings = {"myMono", "Flux", "Stream"})
    void parameterizedAnnotationTest(String param) {
        var expected = Pattern.compile("myMono|Flux|Stream");
        Assertions.assertTrue(expected.matcher(param).find(), () -> "Assertion message");
    }

//    @Test
    @DisplayName("/my-mock 을 호출하고 bean 을 반환받는다.")
    void testMockController() throws Exception {
        //given, when
        MvcResult bean = mvc.perform(get("/my-mock")
                .session(session)

        )
                .andExpect(status().isOk())
                .andExpect(content().string("bean"))
                .andDo(System.out::println)
                .andReturn();


        //then
//        Assertions.assertEquals(200, bean.getResponse().getStatus());
//        Assertions.assertEquals("bean", bean.getRequest().getContentAsString());

    }
}