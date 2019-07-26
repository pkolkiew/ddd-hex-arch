package pl.pkolkiew.dddhexarch.user.domain.query;

import lombok.Getter;
import lombok.Value;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
@Getter
@Value
public class UserQueryDto {
    // TODO: CQRS - jeszcze nie wiem jak
    private final String login;

}
