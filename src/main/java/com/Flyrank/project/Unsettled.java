package com.Flyrank.project;
import jakarta.persistence.*;

@Table(name = "tb_modx'el")
@Entity(name = "unsettled")
public class Unsettled {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    private String description;

    private String  img_url;


}
