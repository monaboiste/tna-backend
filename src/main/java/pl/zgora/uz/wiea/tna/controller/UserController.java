package pl.zgora.uz.wiea.tna.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
