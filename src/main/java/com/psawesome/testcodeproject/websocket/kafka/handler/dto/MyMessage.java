package com.psawesome.testcodeproject.websocket.kafka.handler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * package: com.psawesome.testcodeproject.websocket.kafka.handler.dto
 * author: PS
 * DATE: 2020-03-28 토요일 22:32
 */
@AllArgsConstructor
@Data
public class MyMessage {
    private String type;
    private String message;
}
