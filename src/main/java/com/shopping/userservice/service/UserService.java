package com.shopping.userservice.service;

import com.shopping.userservice.controller.dto.CreateUserDTO;
import com.shopping.userservice.controller.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(CreateUserDTO createUserDTO);
}
