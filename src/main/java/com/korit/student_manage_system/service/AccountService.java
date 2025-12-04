package com.korit.student_manage_system.service;

import com.korit.student_manage_system.Security.model.Principal;
import com.korit.student_manage_system.dto.ApiRespDto;
import com.korit.student_manage_system.dto.ChangePasswordReqDto;
import com.korit.student_manage_system.entity.User;
import com.korit.student_manage_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service

public class AccountService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApiRespDto<?> changePassword(@RequestBody ChangePasswordReqDto changePasswordReqDto, Principal principal) {
        if (!changePasswordReqDto.getUserId().equals(principal.getUserId())) {
            return new ApiRespDto<>("failed", "잘못된 요청 입니다", null);
        }
        Optional<User> foundUser = userRepository.getUserById(changePasswordReqDto.getUserId());
        if (foundUser.isEmpty()) {
            return new ApiRespDto<>("failed", "존재하지 않는 사용자 입니다", null);
        }
        if (!bCryptPasswordEncoder.matches(changePasswordReqDto.getOldPassword(), foundUser.get().getPassword())) {
            return new ApiRespDto<>("failed", "일치하지 않는 비밀번호 입니다", null);
        }
        if (bCryptPasswordEncoder.matches(changePasswordReqDto.getNewPassword(), foundUser.get().getPassword())) {
            return new ApiRespDto<>("failed", "같은 비밀번호를 사용할 수 없습니다", null);
        }
        int result = userRepository.modifyPassword(
                changePasswordReqDto.getUserId(),
                bCryptPasswordEncoder.encode(changePasswordReqDto.getNewPassword())
        );
        if (result != 1) {
            return new ApiRespDto<>("failed", "실패", null);
        }
        return new ApiRespDto<>("success", "성공", null);
    }

    public ApiRespDto<?> removeStudent(Integer userId) {
        Optional<User> foundStudent = userRepository.getUserById(userId);
        if (foundStudent.isEmpty()) {
            return new ApiRespDto<>("failed", "해당 존재하지 않습니다.", null);
        }
        int result = userRepository.removeStudent(foundStudent.get().getUserId());
        if (result != 1) {
            return new ApiRespDto<>("failed", "삭제하는데 문제가 발생했습니다.", null);
        }
        return new ApiRespDto<>("success", "삭제되었습니다.", null);
    }
}




