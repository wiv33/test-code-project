package com.psawesome.testcodeproject.websocket.kafka.handler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * package: com.psawesome.testcodeproject.websocket.kafka.handler.config
 * author: PS
 * DATE: 2020-03-28 토요일 22:45
 */
@Configuration
public class ReactiveWebSocketConfiguration {

    final WebSocketHandler webSocketHandler;

    public ReactiveWebSocketConfiguration(WebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }

    @Bean
    public HandlerMapping websocketHandlerMapping() {
        Map<String, WebSocketHandler> urlMap = new HashMap<>();

        urlMap.put("/websocket", webSocketHandler);

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://localhost:4200");

        Map<String, CorsConfiguration> corsConfigurationMap = new HashMap<>();
        corsConfigurationMap.put("/websocket", corsConfiguration);

        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(1);
        mapping.setUrlMap(urlMap);
        mapping.setCorsConfigurations(corsConfigurationMap);

        return mapping;
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }

}
