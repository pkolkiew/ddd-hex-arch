package pl.pkolkiew.dddhexarch.user.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
@Configuration
class UserConfiguration {

    // do wykorzystania w testach - fasada i wszystko bez podnoszenia spring'a
    UserFacade userFacade() {
        return userFacade(new InMemoryUserRepository());
    }

    @Bean
    UserFacade userFacade(UserRepository userRepository) {
        UserCreator userCreator = new UserCreator();
        return new UserFacade(userRepository, userCreator);
    }

//    @Bean
//    @Profile("in-memory")
//    UserFacade userFacadeInMemory() {
//        UserCreator userCreator = new UserCreator();
//        return new UserFacade(new InMemoryUserRepository(), userCreator);
//    }
}
