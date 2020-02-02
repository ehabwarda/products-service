package com.demo.products.api;

import com.demo.products.dto.ProductDTO;
import com.demo.products.entity.Product;
import com.demo.products.mapper.ProductMapper;
import com.demo.products.service.ProductService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public List<ProductDTO> getProducts() {
        LOG.debug("get all products");
        return productMapper.entityListToApiList(productService.getProducts());
    }

    @GetMapping("/{productId}")
    public ProductDTO getProduct(@PathVariable  Long productId) {
        LOG.debug("get product with id: {}", productId);
        final Product product = productService.getProduct(productId);
        return productMapper.entityToApi(product);
    }

    @PutMapping("/{productId}")
    public ProductDTO updateProduct(@PathVariable  Long productId, @RequestBody ProductDTO product) {
        LOG.debug("update product with id: {}", productId);
        final Product productEntity = productMapper.apiToEntity(product);
        productEntity.setId(productId);
        return productMapper.entityToApi(productService.saveProduct(productEntity));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product) {
        LOG.debug("create new product");
        final ProductDTO createdProduct = productMapper
                .entityToApi(productService.saveProduct(productMapper.apiToEntity(product)));
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

}
