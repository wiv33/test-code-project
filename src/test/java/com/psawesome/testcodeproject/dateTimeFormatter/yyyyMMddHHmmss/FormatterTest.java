package com.psawesome.testcodeproject.dateTimeFormatter.yyyyMMddHHmmss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author pilseong
 * @version 1.0
 * @description
 * @see == 개정이력(Modification Information) ==
 * <p>
 * 수정일             수정자            수정내용
 * ------          --------      --------------------------
 * @since 2020-03-02
 */

public class FormatterTest {

    @Test
    void LocalDateTimeTest() {
        String input = "20191024194947087";
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime ldt = LocalDateTime.parse(input.substring(0, 14), f);
        String format = ldt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        Assertions.assertEquals("2019/10/24 19:49:47", format);
    }
}
