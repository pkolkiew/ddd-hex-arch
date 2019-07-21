package pl.pkolkiew.dddhexarch.model.user.domain.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
@Builder
@Getter
@EqualsAndHashCode
public class UserDto {

    private String login;
    private String pass;
    private int isActive;

    public UserDto(String login, String pass, int isActive) {
        this.login = login;
        this.pass = pass;
        this.isActive = isActive;
    }
}
