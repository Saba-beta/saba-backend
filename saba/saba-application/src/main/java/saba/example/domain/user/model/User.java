package saba.example.domain.user.model;

import lombok.Builder;
import lombok.Getter;
import saba.example.common.annotation.Aggregate;
import saba.example.domain.auth.model.type.Authority;
// TODO 수정수정수정수정
// TODO 카드등록
@Aggregate
@Getter
@Builder(toBuilder = true)
public class User {
    private String id;

    private String accountId;

    private String password;

    private String name;

    private Authority authority;

    private String email;

    private String profileImage;

    private String address;

    public User changeAccountId(String accountId){
        return this.toBuilder()
                .accountId(accountId)
                .build();
    }


}
