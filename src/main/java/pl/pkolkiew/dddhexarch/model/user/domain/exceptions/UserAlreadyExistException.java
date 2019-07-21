package pl.pkolkiew.dddhexarch.model.user.domain.exceptions;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String login) {
        super("User with login: \"" + login + "\" already exist", null, false, false);
    }
}