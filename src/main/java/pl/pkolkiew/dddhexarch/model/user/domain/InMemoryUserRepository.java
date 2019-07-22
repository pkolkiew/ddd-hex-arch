package pl.pkolkiew.dddhexarch.model.user.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pl.pkolkiew.dddhexarch.model.user.domain.exceptions.UserAlreadyExistException;
import pl.pkolkiew.dddhexarch.model.user.domain.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
class InMemoryUserRepository implements UserRepository {

    private ConcurrentHashMap<String, User> map = new ConcurrentHashMap<>();

    InMemoryUserRepository() {
    }

    @Override
    public User save(User user) {
        String login = user.dto().getLogin();
        if (map.get(login)!=null)
            throw new UserAlreadyExistException(login);
        map.put(login, user);
        return user;
    }

    @Override
    public User findOneOrThrow(String login) {
        User user = map.get(login);
        if (user == null)
            throw new UserNotFoundException(login);
        return user;
    }


    @Override
    public void delete(String login) {
        map.remove(login);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(map.values()), pageable, map.size());
    }

}
