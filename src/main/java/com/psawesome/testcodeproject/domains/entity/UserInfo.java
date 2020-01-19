package com.psawesome.testcodeproject.domains.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * package: com.psawesome.testcodeproject.domains.entity
 * author: PS
 * DATE: 2020-01-19 일요일 15:26
 */
@Document
@AllArgsConstructor
@Getter
@Setter
public class UserInfo {
    @Id
    private Long id;
    private String name;
    private String gender;
}
