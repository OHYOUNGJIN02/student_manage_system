package com.korit.student_manage_system.dto;

import com.korit.student_manage_system.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChangePasswordReqDto {
        private Integer userId;
        private String oldPassword;
        private String newPassword;

        public User toEntity(BCryptPasswordEncoder bCryptPasswordEncoder) {
            return User.builder()
                    .userId(userId)
                    .password(bCryptPasswordEncoder.encode(newPassword))
                    .build();
        }
    }
