package pl.pkolkiew.dddhexarch.user.domain

import groovy.transform.CompileStatic
import pl.pkolkiew.dddhexarch.user.dto.UserDto

/**
 * @author pkolkiew* Created 22.07.2019
 */
@CompileStatic
trait SampleUsers {
    UserDto user1 = createUserDto("login111", "haselko111")
    UserDto user2 = createUserDto("login999", "haselko999")

    private static UserDto createUserDto(String login, String pass) {
        return UserDto.builder()
                .login(login)
                .pass(pass)
                .isActive(1)
                .build()
    }

}