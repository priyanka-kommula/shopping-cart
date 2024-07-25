package com.example.shoppingcart.entity;

import com.example.shoppingcart.model.Address;
import jakarta.persistence.*;
import org.springframework.stereotype.Controller;

@Entity
@Controller
public class UserEntity {
    @Id
    @GeneratedValue
    long id;
    private String firstName;
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AddressEntity address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}

//import jakarta.persistence.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class UserEntity {
//    @Id
//    @GeneratedValue
//    long id;
//    String userName;
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<CartEntity> carts = new ArrayList<>();
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    String email;
//
//    /*public List<Cart> getCarts() {
//        return carts;
//    }
//
//    public void setCarts(List<Cart> carts) {
//        this.carts = carts;
//    }*/
//
//    /*@Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", userName='" + userName + '\'' +
//                ", carts=" + carts +
//                ", email='" + email + '\'' +
//                '}';
//    }*/
//}
