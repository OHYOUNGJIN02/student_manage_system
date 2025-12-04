package com.korit.student_manage_system.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Role {
    private int roleId;
    private String roleName;
    private String roleNameKor;
}