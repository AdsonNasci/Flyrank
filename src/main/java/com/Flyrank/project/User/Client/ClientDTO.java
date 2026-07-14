package com.Flyrank.project.User.Client;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {
        private Long id;
        private String name;
        private String img_url;
        private int age;
}

