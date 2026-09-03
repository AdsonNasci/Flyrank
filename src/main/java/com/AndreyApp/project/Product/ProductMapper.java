package com.AndreyApp.project.Product;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductModel map(ProductDTO productDTO) {
        ProductModel productModel = new ProductModel();
        productModel.setId(productDTO.getId());
        productModel.setSku(productDTO.getSku());
        productModel.setName(productDTO.getName());
        productModel.setBrand(productDTO.getBrand());
        productModel.setDescription(productDTO.getDescription());
        productModel.setImgUrl(productDTO.getImgUrl());
        productModel.setPrice(productDTO.getPrice());

        return productModel;
    }

    public ProductDTO map(ProductModel productModel) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productModel.getId());
        productDTO.setSku(productModel.getSku());
        productDTO.setName(productModel.getName());
        productDTO.setBrand(productModel.getBrand());
        productDTO.setDescription(productModel.getDescription());
        productDTO.setImgUrl(productModel.getImgUrl());
        productDTO.setPrice(productModel.getPrice());

        return productDTO;
    }
}
