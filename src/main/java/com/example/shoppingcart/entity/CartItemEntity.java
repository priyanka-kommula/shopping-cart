package com.example.shoppingcart.entity;

import jakarta.persistence.*;

@Entity
public class CartItemEntity {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private CartEntity cart;
    @ManyToOne(cascade = CascadeType.ALL)
    private ProductEntity product;
    private int quantity;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", cart=" + cart +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
