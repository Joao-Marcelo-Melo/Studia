package com.jmz.studia.controller;

import com.jmz.studia.domain.User.User;
import com.jmz.studia.domain.User.UserRequestDTO;
import com.jmz.studia.domain.User.UserResponseDTO;
import com.jmz.studia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO body) {
        User newUser = this.userService.createUser(body);
        UserResponseDTO response = new UserResponseDTO(newUser);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable UUID id) {
        User user = this.userService.getUser(id);
        UserResponseDTO response = new UserResponseDTO(user);
        return ResponseEntity.ok(response);
    }
}
