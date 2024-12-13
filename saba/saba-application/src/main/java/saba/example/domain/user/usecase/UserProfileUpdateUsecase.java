package saba.example.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import saba.example.common.annotation.UseCase;
import saba.example.common.spi.SecurityPort;
import saba.example.domain.user.model.User;
import saba.example.domain.user.spi.UserPort;

@UseCase
@RequiredArgsConstructor
// TODO S3 연동
public class UserProfileUpdateUsecase {
    private final UserPort userPort;
    private final SecurityPort securityPort;

    @Transactional
    public void execute(String image){
        User user = securityPort.getCurrentUser();
        user.changeProfileImage(image);
    }
}
