package com.jmz.studia.service;

import com.jmz.studia.domain.User.User;
import com.jmz.studia.domain.User.UserRequestDTO;
import com.jmz.studia.repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequestDTO data) {

        if (this.userRepository.findByEmail(data.email()) != null) throw new EntityExistsException("user already exist");

        User user = User.builder()
        .name(data.name())
        .email(data.email())
        .password(hashPassword(data.password()))
        .role(data.role())
        .build();

        this.userRepository.save(user);
        return user;
    }

    public User getUser(UUID id) {
        return this.userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User Not Found"));
    }

    private String hashPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
