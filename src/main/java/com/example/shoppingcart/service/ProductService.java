package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id) throws Exception {
       Optional<Product> optionalProduct = productRepository.findById(id);
       if(optionalProduct.isPresent()) {
           return optionalProduct.get();
       }else {
           throw new Exception("product with id" + id + " is not found");
       }

    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(long id,Product product) throws Exception {
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);

    }
    public void deleteById(long id){

        productRepository.deleteById(id);

    }

}
