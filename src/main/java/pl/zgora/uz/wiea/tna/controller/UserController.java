package pl.zgora.uz.wiea.tna.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.zgora.uz.wiea.tna.model.User;
import pl.zgora.uz.wiea.tna.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    List<User> fetchAllUsers() {
        return userService.fetchAllUsers();
    }

    @GetMapping("/{id}")
    User fetchUserById(@PathVariable("id") long id) {
        return userService.fetchUserById(id);
    }

    @PostMapping
    User createUser(@RequestBody final User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }
}
