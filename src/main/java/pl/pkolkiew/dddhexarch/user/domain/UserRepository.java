package pl.pkolkiew.dddhexarch.user.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
interface UserRepository {

    User save(User user);

    User findOneOrThrow(String login);

    // TODO unit tests
    void delete(String login);

    Page<User> findAll(Pageable pageable);

}
