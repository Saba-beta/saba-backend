package saba.example.domain.user.model;

import lombok.Builder;
import lombok.Getter;
import saba.example.common.annotation.Aggregate;
import saba.example.domain.auth.model.type.Authority;
// TODO 집 주소 추가 고려하기
@Aggregate
@Getter
@Builder(toBuilder = true)
public class User {
    private String id;

    private String accountId;

    private String password;

    private Authority authority;

    private String email;

    private String profileImage;


    public User changeAccountId(String accountId){
        return this.toBuilder()
                .accountId(accountId)
                .build();
    }


}
