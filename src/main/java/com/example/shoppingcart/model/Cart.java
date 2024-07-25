package com.example.shoppingcart.model;

import java.util.List;

public class Cart {

    private int id;

    private List<CartItem> cartItemList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartItemList=" + cartItemList +
                '}';
    }
}
