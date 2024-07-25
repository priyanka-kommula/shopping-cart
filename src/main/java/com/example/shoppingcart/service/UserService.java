package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.AddressEntity;
import com.example.shoppingcart.entity.UserEntity;
import com.example.shoppingcart.model.Address;
import com.example.shoppingcart.model.User;
import com.example.shoppingcart.model.UserRequest;
import com.example.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(UserRequest user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());

        AddressEntity address = new AddressEntity();
        address.setStreetName(user.getAddress().getStreetName());
        address.setHouseNumber(user.getAddress().getHouseNumber());
        address.setPincode(user.getAddress().getPincode());

        userEntity.setAddress(address);

        userEntity = userRepository.save(userEntity);
        User user1 = new User();
        user1.setId((int)userEntity.getId());
        user1.setFirstName(userEntity.getFirstName());
        user1.setLastName(userEntity.getLastName());

        Address address1 = new Address();
        address.setStreetName(userEntity.getAddress().getStreetName());
        address.setHouseNumber(userEntity.getAddress().getHouseNumber());
        address.setPincode(userEntity.getAddress().getPincode());

        user1.setAddress(address1);
        return user1;
    }
}
