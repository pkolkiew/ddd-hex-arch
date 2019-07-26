package pl.pkolkiew.dddhexarch.user.domain.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.pkolkiew.dddhexarch.user.domain.UserFacade;
import pl.pkolkiew.dddhexarch.user.domain.query.UserQueryDto;
import pl.pkolkiew.dddhexarch.user.dto.UserDto;

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

    @GetMapping(path = "/show/{userQueryDto}")
    UserDto findUser(@PathVariable UserQueryDto userQueryDto) {
        return userFacade.show(userQueryDto.getLogin());
    }

}
