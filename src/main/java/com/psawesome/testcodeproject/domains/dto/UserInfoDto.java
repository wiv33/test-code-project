package com.psawesome.testcodeproject.domains.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * package: com.psawesome.testcodeproject.domains.dto
 * author: PS
 * DATE: 2020-01-19 일요일 15:25
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {

    private Long id;
    private String name;
    private String gender;
}
