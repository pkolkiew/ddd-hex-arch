package pl.pkolkiew.dddhexarch.model.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
interface UserJpaRepository extends JpaRepository<User, String> {
}
