package com.Flyrank.project;
import jakarta.persistence.*;

@Table(name = "tb_model")
@Entity(name = "unsettled")
public class Unsettled {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;

    private String description;

    private String  img_url;


}
