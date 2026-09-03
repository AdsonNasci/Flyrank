package com.AndreyApp.project.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
        private Long id;
        private String name;
        private String login;
        private String imgUrl;
        private String email;
        @JsonIgnore
        private String password;
        private UserRole userRole;
}

