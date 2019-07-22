package pl.pkolkiew.dddhexarch.user.domain;

import pl.pkolkiew.dddhexarch.user.dto.UserDto;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
class UserCreator {

    User from(UserDto userDto) {
        requireNonNull(userDto);
        return User.builder()
                .login(userDto.getLogin())
                .pass(userDto.getPass())
                .isActive(1)
                .userId(UUID.randomUUID())
                .build();

    }

}
