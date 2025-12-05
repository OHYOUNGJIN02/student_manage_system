package com.korit.student_manage_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ModifyJournalReqDto {

    private Integer userId;
    private Integer stdtClsId;
    private String password;

}
