package com.korit.student_manage_system.dto;

import com.korit.student_manage_system.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class SignInReqDto {
    private String username;
    private String password;


    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .build();
}}
