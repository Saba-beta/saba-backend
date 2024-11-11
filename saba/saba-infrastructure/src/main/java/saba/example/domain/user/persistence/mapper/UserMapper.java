package saba.example.domain.user.persistence.mapper;

import org.springframework.stereotype.Component;
import saba.example.domain.user.model.User;
import saba.example.domain.user.persistence.entity.UserEntity;

@Component
public class UserMapper {
    public User toDomain(UserEntity userEntity){
        return User.builder()
                .id(userEntity.getId())
                .accountId(userEntity.getAccountId())
                .password(userEntity.getPassword())
                .profileImage(userEntity.getProfileImage())
                .authority(userEntity.getAuthority())
                .build();
    }

    public UserEntity toEntity(User user){
        return UserEntity.builder()
                .id(user.getId())
                .accountId(user.getAccountId())
                .password(user.getPassword())
                .profileImage(user.getProfileImage())
                .authority(user.getAuthority())
                .build();
    }
}
