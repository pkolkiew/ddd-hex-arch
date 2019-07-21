package pl.pkolkiew.dddhexarch.model.user.domain;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pl.pkolkiew.dddhexarch.model.user.domain.exceptions.UserNotFoundException;

import java.util.Optional;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
@Repository
@Profile("!in-memory")
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
