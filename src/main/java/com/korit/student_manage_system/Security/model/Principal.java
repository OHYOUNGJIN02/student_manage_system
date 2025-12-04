package com.korit.student_manage_system.Security.model;

import com.korit.student_manage_system.entity.UserRole;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class Principal implements UserDetails {
    private Integer userId;
    private String username;
    private Integer age;
    private String password;
    private String email;

    private List<UserRole> userRoles =  new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRoles.stream().map(
                userRole -> new SimpleGrantedAuthority(userRole.getRole().getRoleName())
        ).collect(Collectors.toList());
    }}
