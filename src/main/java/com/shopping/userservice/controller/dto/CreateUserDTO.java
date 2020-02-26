package com.shopping.userservice.controller.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "All details of user")
public class CreateUserDTO {

    private UserProfileDTO userProfile;
    private String email;
    private String password;
    private String mobile;


}
