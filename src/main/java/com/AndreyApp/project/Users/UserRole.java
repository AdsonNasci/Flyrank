package com.AndreyApp.project.Users;

public enum UserRole {
    ADMIN("admin"),
    CLIENT("client");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
