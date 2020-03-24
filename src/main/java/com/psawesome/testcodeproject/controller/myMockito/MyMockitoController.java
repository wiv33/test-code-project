package com.psawesome.testcodeproject.controller.myMockito;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * package: com.psawesome.testcodeproject.controller.myMockito
 * author: PS
 * DATE: 2020-03-24 화요일 22:56
 */
@Controller
public class MyMockitoController {

    @GetMapping("/my-mock")
    @ResponseBody
    public String myMockitoTest() {
        return "bean";
    }
}
