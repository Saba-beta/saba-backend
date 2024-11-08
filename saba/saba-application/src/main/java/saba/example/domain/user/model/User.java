package saba.example.domain.user.model;

import lombok.Builder;
import lombok.Getter;
import saba.example.common.annotation.Aggregate;
import saba.example.domain.auth.model.Authority;

@Aggregate
@Getter
@Builder(toBuilder = true)
public class User {
    private Long id;

    private String accountId;

    private String password;

    private String profileImage;

    private Authority authority;

    public User changeAccountId(String accountId){
        return this.toBuilder()
                .accountId(accountId)
                .build();
    }


}
