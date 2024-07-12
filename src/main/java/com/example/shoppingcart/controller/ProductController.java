package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")

    public @ResponseBody List<Product> getAllProducts() {

        return productService.getAllProducts();

    }
    @GetMapping("/products/{id}")
    public @ResponseBody Product getProductById(@PathVariable Long id) throws Exception {

        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public @ResponseBody Product createProduct(@RequestBody Product product) {

        return productService.createProduct(product);
    }
    @PutMapping("/product/{id}")

    public @ResponseBody Product updateProduct(@RequestBody Product product, @PathVariable long id) throws Exception {

        return productService.updateProduct(id, product);
    }
    @DeleteMapping("/product/{id}")

    public @ResponseBody String deleteProduct(@PathVariable long id) {
        productService.deleteById(id);
        return "Success";

    }
}