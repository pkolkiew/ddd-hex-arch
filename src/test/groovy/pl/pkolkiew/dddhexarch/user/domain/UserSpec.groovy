package pl.pkolkiew.dddhexarch.user.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import pl.pkolkiew.dddhexarch.user.domain.exceptions.UserNotFoundException
import pl.pkolkiew.dddhexarch.user.dto.UserDto
import spock.lang.Specification

/**
 * @author pkolkiew* Created 22.07.2019
 */
class UserSpec extends Specification implements SampleUsers {
    UserFacade userFacade = new UserConfiguration().userFacade()

    def "should find user"() {
        given: "user exists in db"
            userFacade.addUser(user1)
        expect: "system returns user"
            userFacade.show(user1.login) == user1
    }

    def "should throw exception when get user that not exists in db" () {
        when: "system is asked for user that doesn't exist"
            userFacade.show("bla bla 123")
        then:
            thrown(UserNotFoundException)
    }

    def "should return pageable list of users" () {
        given: "there are 2 users in system"
            userFacade.addUser(user1)
            userFacade.addUser(user2)
        when: "we ask for all users info"
            Page<UserDto> users = userFacade.findAll(new PageRequest(0, 10))
        then: "system return users that we added"
            users.contains(user1)
            users.contains(user2)
    }

}