package com.pfe.challenge.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.pfe.challenge.Service.AuthService;
import com.pfe.challenge.Model.User;

import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200")
@RestController

@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;





    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
        Map<String, Object> response = authService.login(user.getUsername(), user.getPassword());

        if (!(Boolean) response.get("success")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        return ResponseEntity.ok(response);
    }






    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody User user, @PathVariable Long id) {
        String result = authService.update(user,id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        System.out.println("Received user: " + user);
        return authService.register(user);
    }
}
