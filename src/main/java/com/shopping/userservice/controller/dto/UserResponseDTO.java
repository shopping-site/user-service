package com.shopping.userservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private String userId;
    private String email;
    private String firstName;
    private String lastName;
    private Set<RoleDTO> roles = new HashSet<>();

}
