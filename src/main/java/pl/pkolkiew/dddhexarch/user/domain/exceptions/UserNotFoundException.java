package pl.pkolkiew.dddhexarch.user.domain.exceptions;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String login) {
        super("No user with login: \"" + login + "\" found", null, false, false);
    }
}