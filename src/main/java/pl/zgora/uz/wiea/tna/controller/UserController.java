package pl.zgora.uz.wiea.tna.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.zgora.uz.wiea.tna.model.User;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.service.UserService;
import pl.zgora.uz.wiea.tna.util.UserUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    List<User> fetchAllUsers() {
        final List<UserEntity> userEntities = userService.fetchAllUsers();
        final List<User> users = userEntities.parallelStream()
                .map(UserUtils::mapUserEntityToUser)
                .collect(Collectors.toList());
        return users;
    }

    @GetMapping("/{id}")
    User fetchUserById(@PathVariable("id") long id) {
        final UserEntity userEntity = userService.fetchUserById(id);
        return UserUtils.mapUserEntityToUser(userEntity);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    User createUser(@RequestBody final User user){
        final UserEntity userEntity = userService.createUser(UserUtils.mapUserToUserEntity(user));
        return UserUtils.mapUserEntityToUser(userEntity);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    void deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }
}
