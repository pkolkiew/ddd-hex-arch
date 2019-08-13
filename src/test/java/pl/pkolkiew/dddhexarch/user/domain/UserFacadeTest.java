package pl.pkolkiew.dddhexarch.user.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pl.pkolkiew.dddhexarch.user.domain.exceptions.UserAlreadyExistException;
import pl.pkolkiew.dddhexarch.user.domain.exceptions.UserNotFoundException;
import pl.pkolkiew.dddhexarch.user.dto.UserDto;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
public class UserFacadeTest {

    private UserFacade userFacade = new UserConfiguration().userFacade();
    private UserDto userDto;

    private final String LOGIN = "login123";

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        //setUp
        this.userDto = UserDto.builder()
                .login(LOGIN)
                .pass("pass123")
                .isActive(1)
                .build();
    }

    @Test
    public void addUser() {
        //given this.userDto
        //when
        UserDto newUserDto = userFacade.addUser(this.userDto);
        //then
        Assert.assertEquals(newUserDto, userDto);
    }

    @Test
    public void show() {
        //given
        userFacade.addUser(this.userDto);
        //when
        UserDto userDto = userFacade.show(LOGIN);
        //then
        Assert.assertNotNull(userDto);
    }

    @Test
    public void findAllTest() {
        //given
        userFacade.addUser(this.userDto);
        Pageable pageable = PageRequest.of(0, 5);
        //when
        Page<UserDto> resultList = userFacade.findAll(pageable);
        //then
        Assert.assertNotNull(resultList);
        Assert.assertEquals(1L, resultList.getTotalElements());
        Assert.assertTrue(resultList.getContent().get(0).getLogin().equalsIgnoreCase(LOGIN));
    }


    // JUnit5 way, using @Rule ExpectedException
    @Test
    public void saveUserThatAlreadyExistThrowsUserAlreadyExistException() {
        //given
        userFacade.addUser(this.userDto);
        //when
        exception.expect(UserAlreadyExistException.class);
        userFacade.addUser(this.userDto);
        //then
        // test throws exception and its fine
        System.out.println("test throws exception and its fine");
    }

    @Test
    public void showUserThatNotExistAndThrowUserNotFoundException() {
        //given
        exception.expect(UserNotFoundException.class);
        //when
        userFacade.show("XZY" + LOGIN);
        //then
        // test throws exception and its fine
        System.out.println("test throws exception and its fine");
    }


}