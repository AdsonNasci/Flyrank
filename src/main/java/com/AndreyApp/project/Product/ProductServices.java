package com.AndreyApp.project.Product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ProductServices {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final PasswordEncoder passwordEncoder;


    public ProductDTO findProductById(@PathVariable Long id, ProductDTO productDTO) {
        Optional<ProductModel> product = productRepository.findById(id);
        if (product.isPresent()) {
            ProductModel updatedProduct = productMapper.map(productDTO);
            updatedProduct.setId(id);
            ProductModel savedUser = productRepository.save(updatedProduct);
            return productMapper.map(savedUser);
        }
        return null;
    }



}
