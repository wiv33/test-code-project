package com.psawesome.testcodeproject.userInfo.dto;

import com.psawesome.testcodeproject.userInfo.entity.UserInfo;
import com.psawesome.testcodeproject.userInfo.repo.UserInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * package: com.psawesome.testcodeproject.domains.dto
 * author: PS
 * DATE: 2020-01-19 일요일 15:28
 */
@DataMongoTest
class UserInfoTest {

    @Autowired
    UserInfoRepository repository;

    @Autowired
    ReactiveMongoOperations reactiveMongoOperations;

    @BeforeEach
    void setUp() {
        System.out.println("UserInfoTest.setUp");
/*
        reactiveMongoOperations.dropCollection(UserInfo.class);
        reactiveMongoOperations.insertAll(Arrays.asList(
                new UserInfo(1L, "Flux", "man"),
                new UserInfo(2L, "Mono", "woman"),
                new UserInfo(3L, "Reactive", "man"),
                new UserInfo(4L, "SpringBoot", "man")
        ));
*/

/*
        reactiveMongoOperations.insert(new UserInfo(1L, "Flux", "man"));
        reactiveMongoOperations.insert(new UserInfo(2L, "Mono", "woman"));
        reactiveMongoOperations.insert(new UserInfo(3L, "Reactive", "man"));
        reactiveMongoOperations.insert(new UserInfo(4L, "SpringBoot", "man"));
*/

        repository.deleteAll();

        repository.saveAll(Arrays.asList(
                new UserInfo(1L, "Flux", "man"),
                new UserInfo(2L, "Mono", "woman"),
                new UserInfo(3L, "Reactive", "man"),
                new UserInfo(4L, "SpringBoot", "man")
        ));

/*
        repository.save(new UserInfo(1L, "Flux", "man"));
        repository.save(new UserInfo(2L, "Mono", "woman"));
        repository.save(new UserInfo(3L, "Reactive", "man"));
        repository.save(new UserInfo(4L, "SpringBoot", "man"));
*/
    }

    @Test
    void name() {
        StepVerifier.create(repository.findAll())
                .recordWith(ArrayList::new)
                .expectNextCount(4)
                .consumeRecordedWith(results -> assertAll(
                        () -> assertThat(results)
                                .extracting(UserInfo::getName)
                                .contains("Flux", "Mono", "Reactive", "SpringBoot")
                ))
                .expectComplete()
                .verify()
        ;
    }


}