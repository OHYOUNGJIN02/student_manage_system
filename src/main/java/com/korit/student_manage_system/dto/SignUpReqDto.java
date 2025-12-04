package com.korit.student_manage_system.dto;

import com.korit.student_manage_system.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor


public class SignUpReqDto {
    private String username;
    private String password;
    private Integer age;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .age(age)
                .build();
    }
}

