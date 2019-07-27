package pl.pkolkiew.dddhexarch.user.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pkolkiew.dddhexarch.user.dto.UserDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
@Data
@Entity(name = "USER_DDD")
@NoArgsConstructor
class User {

    @Id
    private String login;
    private String pass;
    private int isActive;
    private UUID userId;

    private User(UserBuilder builder) {
        this.login = builder.login;
        this.pass = builder.pass;
        this.isActive = builder.isActive;
        this.userId = builder.userId;
    }

    UserDto dto() {
        return UserDto.builder()
                .login(login)
                .pass(pass)
                .isActive(isActive)
                .build();
    }

     static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String login;
        private String pass;
        private int isActive;
        private UUID userId;

        private UserBuilder() {

        }

         UserBuilder login(String login) {
            this.login = login;
            return this;
        }

         UserBuilder pass(String pass) {
            this.pass = pass;
            return this;
        }

         UserBuilder isActive(int isActive) {
            this.isActive = isActive;
            return this;
        }

         UserBuilder userId(UUID userId) {
            this.userId = userId;
            return this;
        }

         User build() {
            return new User(this);
        }

    }

}
