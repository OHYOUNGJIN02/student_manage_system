package com.korit.student_manage_system.controller;

import com.korit.student_manage_system.dto.SignInReqDto;
import com.korit.student_manage_system.dto.SignUpReqDto;
import com.korit.student_manage_system.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/signup")
    private ResponseEntity<?> signup(@RequestBody SignUpReqDto  signUpReqDto) {
        return ResponseEntity.ok().body(authService.signup(signUpReqDto));
    }
    @PostMapping("/signin")
    private ResponseEntity<?> signin(@RequestBody SignInReqDto signInReqDto) {
        return ResponseEntity.ok().body(authService.signin(signInReqDto));
    }
    @GetMapping("/list")
    private ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok().body(authService.getAllUsers());
    }
}
