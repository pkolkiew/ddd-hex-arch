package pl.pkolkiew.dddhexarch.user.domain;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
class UserConfiguration {

    // do wykorzystania w testach - fasada i wszystko bez podnoszenia spring'a
    UserFacade userFacade() {
        return userFacade(new InMemoryUserRepository());
    }

    UserFacade userFacade(UserRepository userRepository) {
        UserCreator userCreator = new UserCreator();
        return new UserFacade(userRepository, userCreator);
    }

}
