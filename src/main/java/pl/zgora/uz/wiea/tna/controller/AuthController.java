package pl.zgora.uz.wiea.tna.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.zgora.uz.wiea.tna.model.LoginCredentials;

@RestController
public class AuthController {

    @PostMapping("/auth/login")
    public void login(@RequestBody final LoginCredentials creds) {
    }
}
