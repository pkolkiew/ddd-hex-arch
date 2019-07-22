package pl.pkolkiew.dddhexarch.user.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
interface UserRepository extends Repository<User, String> {

    User save(User user);

    User findOneOrThrow(String login);
    // TODO unit tests
    void delete(String login);

    Page<User> findAll(Pageable pageable);

}
