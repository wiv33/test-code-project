package com.psawesome.testcodeproject.userInfo.repo;

import com.psawesome.testcodeproject.userInfo.entity.UserInfo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * package: com.psawesome.testcodeproject.domains.repo
 * author: PS
 * DATE: 2020-01-19 일요일 15:39
 */
public interface UserInfoRepository extends ReactiveCrudRepository<UserInfo, Long> {

}
