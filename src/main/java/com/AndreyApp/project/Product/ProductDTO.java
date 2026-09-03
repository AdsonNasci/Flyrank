package com.AndreyApp.project.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private Long id;
    private String sku;
    private String name;
    private String brand;
    private String description;
    private String imgUrl;
    private double price;
}
