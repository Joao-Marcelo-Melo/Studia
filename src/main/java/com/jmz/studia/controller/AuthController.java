package com.jmz.studia.controller;

import com.jmz.studia.domain.User.*;
import com.jmz.studia.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var authentication = this.authenticationManager.authenticate(usernamePassword);
        var token = this.tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new AuthResponseDTO(token));
    }
}
