package com.korit.student_manage_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor

public class JoinClassReqDto {
    private int stdtClsId;
    private int clsId;
}
