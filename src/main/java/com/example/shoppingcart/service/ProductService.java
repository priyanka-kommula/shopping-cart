package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.ProductEntity;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.model.ProductRequest;
import com.example.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }

    public Product getProductById(int id) throws Exception {
       /*Optional<Product> optionalProduct = productRepository.findById(id);
       if(optionalProduct.isPresent()) {
           return optionalProduct.get();
       }else {
           throw new Exception("product with id" + id + " is not found");
       }*/

        return null;

    }

    public Product createProduct(ProductRequest productReq){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productReq.getName());
        productEntity.setPrice(productReq.getPrice());
        productEntity = productRepository.save(productEntity);
        Product product=new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setPrice(productEntity.getPrice());
        return product;
    }

    public Product updateProduct(long id, Product product) throws Exception {

        return null;

    }
    public void deleteById(int id){

        productRepository.deleteById(id);

    }

}
