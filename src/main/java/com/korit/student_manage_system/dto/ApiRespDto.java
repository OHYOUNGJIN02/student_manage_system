package com.korit.student_manage_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ApiRespDto <T>{
    private String status;
    private String message;
    private T data;
}
