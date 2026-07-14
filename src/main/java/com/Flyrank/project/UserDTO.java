package com.Flyrank.project;
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
}

