package com.jmz.studia.domain.User;

public record UserRequestDTO(String name, String email, String password, UserRole role) {}
