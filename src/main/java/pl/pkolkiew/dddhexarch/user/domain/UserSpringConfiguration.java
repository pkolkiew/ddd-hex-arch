package pl.pkolkiew.dddhexarch.user.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author pkolkiew
 * Created 24.07.2019
 */
@Configuration
class UserSpringConfiguration {

//    @Bean
//    UserFacade userFacade() {
//        return new UserFacade(userRepository(), new UserCreator());
//    }

    @Bean
    UserRepository userRepository(UserJpaRepository userJpaRepository) {
        return new DatabaseUserRepository(userJpaRepository);
    }

    @Bean
    @Profile("test")
    UserFacade userFacade(UserJpaRepository userJpaRepository) {
        UserCreator userCreator = new UserCreator();
        return new UserFacade(new DatabaseUserRepository(userJpaRepository), userCreator);
    }

}
