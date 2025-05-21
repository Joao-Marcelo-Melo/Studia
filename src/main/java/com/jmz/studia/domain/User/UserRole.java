package com.jmz.studia.domain.User;

public enum UserRole {
    INSTRUCTOR("INSTRUCTOR"),
    STUDENT("STUDENT");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
