package com.korit.student_manage_system.service;

import com.korit.student_manage_system.Security.utils.JwtUtils;
import com.korit.student_manage_system.dto.ApiRespDto;
import com.korit.student_manage_system.dto.SignInReqDto;
import com.korit.student_manage_system.dto.SignUpReqDto;
import com.korit.student_manage_system.entity.User;
import com.korit.student_manage_system.entity.UserRole;
import com.korit.student_manage_system.repository.UserRepository;
import com.korit.student_manage_system.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service



public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtUtils  jwtUtils;


    public ApiRespDto<?> signup(SignUpReqDto signupReqDto) {
        Optional<User> foundUser = userRepository.getUserByUsername(signupReqDto.getUsername());

        if (foundUser.isPresent()) {
            return new ApiRespDto<>("failed", "이미 존재하는 아이디 입니다.", null);
        }
        Optional<User> optionalUser = userRepository.addUser(signupReqDto.toEntity());
        UserRole userRole = UserRole.builder()
                .userId(optionalUser.get().getUserId())
                .roleId(3)
                .build();
        userRoleRepository.addUserRole(userRole);
        return new ApiRespDto<>("success", "회원가입이 완료되었습니다.", optionalUser.get());
    }

    public ApiRespDto<?> signin(SignInReqDto signinReqDto) {
        Optional<User> foundUser = userRepository.getUserByUsername(signinReqDto.getUsername());
        if (foundUser.isEmpty()) {
            return new ApiRespDto<>("failed", "사용자 정보를 다시 확인해주세요.", null);
        }
        User user = foundUser.get();
        if (!bCryptPasswordEncoder.matches(signinReqDto.getPassword(), user.getPassword())) {
            return new ApiRespDto<>("failed", "사용자 정보를 다시 확인해주세요.", null);
        }

        String token = jwtUtils.generateAccessToken(user.getUserId().toString());
        return new ApiRespDto<>("success", "로그인 성공", token);
    }

    public ApiRespDto<?> getAllUsers(){
        return new ApiRespDto<>("successs", "유저 목록", userRepository.getAllUsers());
    }
}
