package com.jmz.studia.domain.User;

public record UserResponseDTO(String name, String email, UserRole role) {
    public UserResponseDTO(User user) {
        this(user.getName(), user.getEmail(), user.getRole());
    }
}
