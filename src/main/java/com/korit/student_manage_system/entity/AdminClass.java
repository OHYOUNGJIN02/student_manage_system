package com.korit.student_manage_system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AdminClass {
    private Integer clsId;
    private String clsName;
    private String clsDscpt;

}
