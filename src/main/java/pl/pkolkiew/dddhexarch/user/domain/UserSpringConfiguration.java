package pl.pkolkiew.dddhexarch.user.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pkolkiew
 * Created 24.07.2019
 */
@Configuration
class UserSpringConfiguration {

    @Bean
    UserFacade userFacade() {
        return new UserFacade(userRepository(), new UserCreator());
    }

    @Bean
    UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

}
