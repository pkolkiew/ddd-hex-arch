package pl.pkolkiew.dddhexarch.user.domain.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryDto {
    // TODO: CQRS - dont know shit, but I'm doing this...
    private String login;

}
