package pl.zgora.uz.wiea.tna.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.zgora.uz.wiea.tna.model.User;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.service.UserService;
import pl.zgora.uz.wiea.tna.util.UserUtils;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import static pl.zgora.uz.wiea.tna.util.UserUtils.mapUserEntityToUser;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/current")
    public User fetchCurrentUser(final Principal principal) {
        final UserEntity userEntity
                = userService.fetchCurrentUserByUsername(principal.getName());
        return mapUserEntityToUser(userEntity);
    }


    @GetMapping
    public List<User> fetchAllUsers() {
        final List<UserEntity> userEntities = userService.fetchAllUsers();
        return userEntities.stream()
                .map(UserUtils::mapUserEntityToUser)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public User fetchUserById(@PathVariable("id") long id) {
        final UserEntity userEntity = userService.fetchUserById(id);
        return mapUserEntityToUser(userEntity);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid final User user){
        final UserEntity userEntity = userService.createUser(UserUtils.mapUserToUserEntity(user));
        return mapUserEntityToUser(userEntity);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }
}
