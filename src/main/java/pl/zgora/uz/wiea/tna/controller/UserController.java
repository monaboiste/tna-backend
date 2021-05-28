package pl.zgora.uz.wiea.tna.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.zgora.uz.wiea.tna.model.User;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.service.UserService;
import pl.zgora.uz.wiea.tna.util.UserUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> fetchAllUsers() {
        final List<UserEntity> userEntities = userService.fetchAllUsers();
        final List<User> users = userEntities.parallelStream()
                .map(UserUtils::mapUserEntityToUser)
                .collect(Collectors.toList());
        return users;
    }

    @GetMapping("/{id}")
    public User fetchUserById(@PathVariable("id") long id) {
        final UserEntity userEntity = userService.fetchUserById(id);
        return UserUtils.mapUserEntityToUser(userEntity);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public User createUser(@RequestBody @Valid final User user){
        final UserEntity userEntity = userService.createUser(UserUtils.mapUserToUserEntity(user));
        return UserUtils.mapUserEntityToUser(userEntity);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }
}
