package com.korit.student_manage_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StudentClass {
    private int stdtClsId;
    private int userId;
    private int clsId;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;

}
