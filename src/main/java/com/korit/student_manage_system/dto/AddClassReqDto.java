package com.korit.student_manage_system.dto;

import com.korit.student_manage_system.entity.AdminClass;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class AddClassReqDto {
    private Integer clsId;
    private String clsName;
    private String clsDscpt;



    public AdminClass toEntity(){
        return AdminClass.builder()
                .clsId(clsId)
                .clsName(clsName)
                .clsDscpt(clsDscpt)
                .build();
    }
}
