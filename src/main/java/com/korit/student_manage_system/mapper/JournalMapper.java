package com.korit.student_manage_system.mapper;

import com.korit.student_manage_system.entity.Journal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper

public interface JournalMapper {

    void addJournal(Journal journal);
    Integer modifyJournal(Integer stdtClsId);
    Integer deleteJournal(Integer stdtClsId);
    List<Journal> getAllJournal();
    Optional<Journal> getJournalById(Integer stdtClsId);


}
