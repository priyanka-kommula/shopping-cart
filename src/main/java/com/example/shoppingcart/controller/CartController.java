package com.example.shoppingcart.controller;

import com.example.shoppingcart.entity.CartEntity;
import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CartController {
    @Autowired

    private CartService cartService;

    @PostMapping("shopping/users/{id}/cart")
    public @ResponseBody Cart createEmptyCart() {
        return cartService.createCart();
    }
    @GetMapping("shopping/cart/{cartId}")
    public @ResponseBody Cart getCartById(@PathVariable int cartId) {
        return cartService.getCartById(cartId);
    }
}



