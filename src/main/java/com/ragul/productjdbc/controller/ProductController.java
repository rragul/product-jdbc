package com.ragul.productjdbc.controller;

import com.ragul.productjdbc.entity.Product;
import com.ragul.productjdbc.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listProducts() {
        return productService.getProducts();
    }

    @GetMapping("{id}")
    public Optional<Product> getProductId(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public String addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}

