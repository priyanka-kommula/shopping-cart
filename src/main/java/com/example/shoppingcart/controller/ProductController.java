package com.example.shoppingcart.controller;

import com.example.shoppingcart.entity.ProductEntity;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.model.ProductRequest;
import com.example.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shopping/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping

    public @ResponseBody List<Product> getAllProducts() {

        return productService.getAllProducts();

    }
    @GetMapping("/{id}")
    public @ResponseBody Product getProductById(@PathVariable int id) throws Exception {

        return productService.getProductById(id);
    }

    @PostMapping
    public @ResponseBody Product createProduct(@RequestBody ProductRequest productReq) {

        return productService.createProduct(productReq);
    }
    @PutMapping("/{id}")

    public @ResponseBody Product updateProduct(@RequestBody Product product, @PathVariable long id) throws Exception {

        return productService.updateProduct(id, product);
    }
    @DeleteMapping("/{id}")

    public @ResponseBody String deleteProduct(@PathVariable int id) {
        productService.deleteById(id);
        return "Success";

    }
}