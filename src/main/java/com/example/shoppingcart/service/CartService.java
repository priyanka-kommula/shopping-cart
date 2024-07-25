package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.CartEntity;
import com.example.shoppingcart.entity.CartItemEntity;
import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.model.CartItem;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CartService {

    @Autowired
    private CartRepository cartRepository;


    public Cart createCart() {
        CartEntity cartEntity = new CartEntity();
        cartEntity = cartRepository.save(cartEntity);
        Cart cart = new Cart();
        cart.setId(cartEntity.getId());

        return cart;
    }

    public Cart getCartById(int cartId) {
        Optional<CartEntity> cartEntity = cartRepository.findById(cartId);
        Cart cart = new Cart();
        cart.setId(cartEntity.get().getId());
        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList = cartEntity.get().getCartItems().stream().map(cartItemEntity -> convertToCartItem(cartItemEntity)).collect(Collectors.toList());
        cart.setCartItemList(cartItemList);
        return cart;
    }

    private CartItem convertToCartItem(CartItemEntity cartItemEntity) {

        CartItem cartItem = new CartItem();
        //use setters to set data
        cartItem.setId(cartItemEntity.getId());

        Product product = new Product();

        product.setId(cartItemEntity.getId());
        product.setName(cartItemEntity.getProduct().getName());
        product.setPrice(cartItemEntity.getProduct().getPrice());
        cartItem.setProduct(product);

        cartItem.setQuantity(cartItemEntity.getQuantity());
        return cartItem;

    }
}
