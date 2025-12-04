package com.korit.student_manage_system.controller;

import com.korit.student_manage_system.Security.model.Principal;
import com.korit.student_manage_system.dto.ChangePasswordReqDto;
import com.korit.student_manage_system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")

public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/modify/password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordReqDto changePasswordReqDto, Principal principal) {
        return ResponseEntity.ok(accountService.changePassword(changePasswordReqDto, principal));
    }

    @PostMapping("/remove")
    public ResponseEntity<?> removeStudent(@RequestParam Integer userId) {
        return ResponseEntity.ok(accountService.removeStudent(userId));
    }
}
