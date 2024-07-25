package com.example.shoppingcart.entity;

import jakarta.persistence.*;

@Entity
public class AddressEntity {
    @Id
    @GeneratedValue
    int id;

    private String streetName;
    private int houseNumber;
    private String pincode;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private UserEntity user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                ", pincode='" + pincode + '\'' +
                ", user=" + user +
                '}';
    }
}
