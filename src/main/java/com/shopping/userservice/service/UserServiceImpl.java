package com.shopping.userservice.service;

import com.shopping.userservice.controller.dto.CreateUserDTO;
import com.shopping.userservice.controller.dto.UserResponseDTO;
import com.shopping.userservice.domain.User;
import com.shopping.userservice.domain.infrastructure.UserRepository;
import com.shopping.userservice.utils.customexception.ShoppingException;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO createUser(CreateUserDTO createUserDTO) {

        Optional<User> userOptional = userRepository.findByEmailOrMobile(createUserDTO.getEmail(), createUserDTO.getMobile());
        if (userOptional.isPresent())
            throw new ShoppingException("An account with this email address or mobile number already exists");


        return null;
    }
}
