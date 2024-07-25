package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.CartEntity;
import com.example.shoppingcart.entity.CartItemEntity;
import com.example.shoppingcart.entity.ProductEntity;
import com.example.shoppingcart.model.CartItem;
import com.example.shoppingcart.model.CartItemRequest;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.repository.CartItemRepository;
import com.example.shoppingcart.repository.CartRepository;
import com.example.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;

    public CartItem cartItemToCart(CartItemRequest cartItemRequest, int cartId) {
        CartItemEntity cartItemEntity = new CartItemEntity();
        Optional<ProductEntity> result = productRepository.findById(cartItemRequest.getProductId());
        cartItemEntity.setProduct(result.orElse(new ProductEntity()));
        Optional<CartEntity> cart = cartRepository.findById(cartId);
        cartItemEntity.setCart(cart.orElse(new CartEntity()));
        cartItemEntity.setQuantity(cartItemRequest.getQuantity());
        cartItemEntity = cartItemRepository.save(cartItemEntity);
        CartItem cartItem = new CartItem();
        Product product = new Product();
        product.setId(cartItemEntity.getProduct().getId());
        product.setName(cartItemEntity.getProduct().getName());
        product.setPrice(cartItemEntity.getProduct().getPrice());


        cartItem.setProduct(product);
        cartItem.setId(cartItemEntity.getId());
        cartItem.setQuantity(cartItemEntity.getQuantity());


        return cartItem;
    }
}
