package com.shopping.userservice.controller;

import com.shopping.userservice.controller.dto.CreateUserDTO;
import com.shopping.userservice.controller.dto.UserResponseDTO;
import com.shopping.userservice.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "To create user", notes = "It is a link to create user", response = UserResponseDTO.class)
    @PostMapping("/create/user")
    public ResponseEntity createUser(@RequestBody CreateUserDTO createUserDTO) {

        UserResponseDTO userResponseDTO = userService.createUser(createUserDTO);
        return ResponseEntity.ok().body(userResponseDTO);

    }
}
