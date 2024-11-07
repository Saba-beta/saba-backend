package saba.example.domain.user.model;

import lombok.Builder;
import lombok.Getter;
import saba.example.common.annotation.Aggregate;

@Aggregate
@Getter
@Builder(toBuilder = true)
public class User {
    private Long id;

    private String accountId;

    private String password;

    private String profileImage;

    public User changeAccountId(String accountId){
        return this.toBuilder()
                .accountId(accountId)
                .build();
    }


}
