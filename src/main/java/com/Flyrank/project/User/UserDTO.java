package com.Flyrank.project.User;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
        private Long id;
        private String name;
        private String img_url;
        private int age;
        private UserType userType;
}

