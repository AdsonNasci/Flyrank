package com.AndreyApp.project.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private Long id;

    //code that comes from the product fabricator, unique for each product
    @Column(name = "sku", unique = true)
    private String sku;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "description")
    private String description;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "category")
    private String category;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}
