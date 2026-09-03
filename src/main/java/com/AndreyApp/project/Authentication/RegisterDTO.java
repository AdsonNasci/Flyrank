package com.AndreyApp.project.Authentication;

import com.AndreyApp.project.Users.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
