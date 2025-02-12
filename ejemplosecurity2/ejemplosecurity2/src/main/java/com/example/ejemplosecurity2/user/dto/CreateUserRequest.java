package com.example.ejemplosecurity2.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequest {
    private String username;
    private String password;
    private String verifyPassword;
    //private String avatar;
    //private String fullName;

}