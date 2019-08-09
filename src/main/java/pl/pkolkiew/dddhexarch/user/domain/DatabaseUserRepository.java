package pl.pkolkiew.dddhexarch.user.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.pkolkiew.dddhexarch.user.domain.exceptions.UserNotFoundException;

import java.util.Optional;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
class DatabaseUserRepository implements UserRepository {

    private UserJpaRepository userJpaRepository;

    public DatabaseUserRepository(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(user);
    }

    @Override
    public User findOneOrThrow(String login) {
        Optional<User> userOpt = userJpaRepository.findById(login);
        if (userOpt.isEmpty())
            throw new UserNotFoundException(login);
        return userOpt.get();
    }

    @Override
    public void delete(String login) {
        Optional<User> userOpt = userJpaRepository.findById(login);
        if (userOpt.isEmpty())
            throw new UserNotFoundException(login);
        userJpaRepository.delete(userOpt.get());
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userJpaRepository.findAll(pageable);
    }
}
