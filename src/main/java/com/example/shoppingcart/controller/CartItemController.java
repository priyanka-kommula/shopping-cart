package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.CartItem;
import com.example.shoppingcart.model.CartItemRequest;
import com.example.shoppingcart.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @PostMapping("shopping/cart/{cartId}/cartItem")
    public @ResponseBody CartItem cartItemToCart(@RequestBody CartItemRequest cartItemRequest, @PathVariable int cartId){

        return cartItemService.cartItemToCart(cartItemRequest, cartId);
    }

}
