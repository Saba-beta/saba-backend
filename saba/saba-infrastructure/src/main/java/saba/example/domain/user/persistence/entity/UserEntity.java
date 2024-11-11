package saba.example.domain.user.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import saba.example.domain.auth.model.Authority;

@Entity
@NoArgsConstructor
@Table(name = "tbl_user")
@Getter
@Builder
@AllArgsConstructor
// TODO 이미지 테이블 분리 고려
public class UserEntity {
    @Id
    private String id;

    @Column(name = "account_id", columnDefinition = "VARCHAR(30)")
    private String accountId;

    @Column(columnDefinition = "VARCHAR(60)")
    private String password;

    @Column(name = "profile_image")
    private String profileImage;

    @Enumerated(value = EnumType.STRING)
    private Authority authority;
}
