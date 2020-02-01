package com.demo.products.repository;

import static org.junit.Assert.assertEquals;

import com.demo.products.entity.Product;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    private static final String PRODUCT_1_NAME = "HTC 10 EVO";
    private static final String PRODUCT_TEST_NAME = "product-test-name";

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void createProduct() {
        Product product = new Product();
        product.setName(PRODUCT_TEST_NAME);
        product.setCurrentPrice(new BigDecimal(100));
        productRepository.save(product);
        assertEquals(PRODUCT_TEST_NAME, productRepository.getOne(5l).getName());
    }

    @Test
    public void getProduct() {
        Product product = productRepository.getOne(1l);
        assertEquals(PRODUCT_1_NAME, product.getName());
    }
}
