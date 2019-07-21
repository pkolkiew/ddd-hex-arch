package pl.pkolkiew.dddhexarch.model.user.domain.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.pkolkiew.dddhexarch.model.user.domain.UserFacade;
import pl.pkolkiew.dddhexarch.model.user.domain.dto.UserDto;

/**
 * @author pkolkiew
 * Created 20.07.2019
 */
@Slf4j
@RestController
@RequestMapping(path = "/user")
class UserController {

    private UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping(path = "/add")
    void addUser(@RequestBody UserDto userDto) {
        userFacade.addUser(userDto);
        log.info("User "+userDto.getLogin()+" added");
    }

    @GetMapping(path = "/users")
    Page<UserDto> findUsers(Pageable pageable) {
        return userFacade.findAll(pageable);
    }

    @GetMapping(path = "/show/{login}")
    UserDto findUser(@PathVariable String login) {
        return userFacade.show(login);
    }

}
