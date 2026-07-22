package com.Flyrank.project.Users;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
        private Long id;
        private String name;
        private String imgUrl;
        private String email;
        private String password;
        private UserRole userRole;
}

