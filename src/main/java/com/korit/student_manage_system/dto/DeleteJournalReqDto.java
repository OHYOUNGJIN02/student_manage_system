package com.korit.student_manage_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class DeleteJournalReqDto {
    public Integer userId;
    public Integer stdtClsId;
    public String password;
}
