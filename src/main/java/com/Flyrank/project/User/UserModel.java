package com.Flyrank.project.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_model")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString()
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "imgUrl")
    private String imgUrl;
    @Column(name ="userType")
    private UserType userType;
}
