package com.korit.student_manage_system.service;


import com.korit.student_manage_system.dto.ApiRespDto;
import com.korit.student_manage_system.entity.Journal;
import com.korit.student_manage_system.mapper.JournalMapper;
import com.korit.student_manage_system.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JournalService {
    @Autowired
    private JournalMapper journalMapper;
    @Autowired
    private JournalRepository journalRepository;

    public ApiRespDto<?> getJournal() {
        return new ApiRespDto<>("success", "전체 일지 조회 성공", journalMapper.getAllJournal());
    }
}
