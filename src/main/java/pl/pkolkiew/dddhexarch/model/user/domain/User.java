package pl.pkolkiew.dddhexarch.model.user.domain;

import lombok.Builder;
import pl.pkolkiew.dddhexarch.model.user.domain.dto.UserDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
@Builder
@Entity
class User {

    @Id
    private String login;
    private String pass;
    private int isActive;
    private UUID userId;

    UserDto dto() {
        return UserDto.builder()
                .login(login)
                .pass(pass)
                .isActive(isActive)
                .build();
    }


}
