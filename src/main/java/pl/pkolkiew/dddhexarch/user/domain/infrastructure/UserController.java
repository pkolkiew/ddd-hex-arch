package pl.pkolkiew.dddhexarch.user.domain.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pkolkiew.dddhexarch.user.domain.UserFacade;
import pl.pkolkiew.dddhexarch.user.domain.exceptions.UserNotFoundException;
import pl.pkolkiew.dddhexarch.user.domain.query.UserQueryDto;
import pl.pkolkiew.dddhexarch.user.dto.ErrorMessageDto;
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
        log.info("User " + userDto.getLogin() + " added");
    }

    @GetMapping(path = "/users")
    Page<UserDto> findUsers(Pageable pageable) {
        return userFacade.findAll(pageable);
    }

    @GetMapping(path = "/show")
    ResponseEntity<?> findUser(@RequestBody UserQueryDto userQueryDto) {
        UserDto userDto = null;
        try {
            userDto = userFacade.show(userQueryDto.getLogin());
        } catch (UserNotFoundException unfe) {
            ErrorMessageDto errorMessage =
                    ErrorMessageDto.createErrorMessage("404", "userNotFound",
                            "brak", "/show", "No user with given login found");
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
