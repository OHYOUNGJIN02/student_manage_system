package com.korit.student_manage_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor

public class Journal {
    private Integer stdtClsId;
    private Integer userId;
    private Integer clsId;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;

}
