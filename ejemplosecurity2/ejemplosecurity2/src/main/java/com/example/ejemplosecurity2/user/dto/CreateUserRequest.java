package com.example.ejemplosecurity2.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public record CreateUserRequest(
    String username,
     String password,
     String verifyPassword
    //private String avatar;
    //private String fullName;
){

}