package saba.project.domain.user.persistence.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import saba.example.domain.auth.model.Authority;
import java.util.UUID;


class UserEntityTest {
    @Test
    @DisplayName("객체 생성 테스트")
    void createUser(){
        UserEntity user = UserEntity.builder()
                .id(UUID.randomUUID().toString())
                .authority(Authority.DEFAULT)
                .accountId("testMan1")
                .password("fjwae3290rjji")
                .profileImage("")
                .build();

        Assertions.assertThat(user.getAccountId()).isEqualTo("testMan1");

    }

}