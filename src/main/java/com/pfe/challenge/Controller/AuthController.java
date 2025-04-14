package com.pfe.challenge.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.pfe.challenge.Service.AuthService;
import com.pfe.challenge.Model.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return authService.login(username, password);
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        System.out.println("Received user: " + user);
        return authService.register(user);
    }
}
