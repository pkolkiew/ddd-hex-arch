package pl.pkolkiew.dddhexarch.user.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.pkolkiew.dddhexarch.user.domain.exceptions.UserNotFoundException;
import pl.pkolkiew.dddhexarch.user.dto.UserDto;

import static java.util.Objects.requireNonNull;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
public class UserFacade {

    private final UserRepository userRepository;
    private final UserCreator userCreator;

    public UserFacade(UserRepository userRepository, UserCreator userCreator) {
        this.userRepository = userRepository;
        this.userCreator = userCreator;
    }

    // TODO: impl event publisher
    public UserDto addUser(UserDto userDto) {
        requireNonNull(userDto);
        validate();
        User user = userCreator.from(userDto);
        user = userRepository.save(user);
        return user.dto();
    }

    public UserDto show(String login) {
        requireNonNull(login);
        validate();
        User user = null;
        try {
            user = userRepository.findOneOrThrow(login);
        } catch (UserNotFoundException unfe) {
            throw unfe;
        }
        return user.dto();
    }

    public Page<UserDto> findAll(Pageable pageable) {
        requireNonNull(pageable);
        return userRepository
                .findAll(pageable)
                .map(User::dto);
    }

    public void delete(String login){
        requireNonNull(login);
        userRepository.delete(login);
    }

    // TODO: impl validate()
    private void validate() {

    }

}
