package com.demo.products.service;

import com.demo.products.entity.Product;
import com.demo.products.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product getProduct(Long productId) {
        return productRepository.getOne(productId);
    }

    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
