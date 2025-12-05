package com.korit.student_manage_system.repository;

import com.korit.student_manage_system.entity.Journal;
import com.korit.student_manage_system.mapper.JournalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class JournalRepository {

    @Autowired
    JournalMapper journalMapper;

    public List<Journal> getAllJournal() {
        return journalMapper.getAllJournal();

    }

    public Optional<Journal> addJournal(Journal journal) {
        try {
            journalMapper.addJournal(journal);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
        return Optional.of(journal);

    }

    public Optional<Journal> getJournalById(Integer stdtClsId) {
        return journalMapper.getJournalById(stdtClsId);
    }

    public Integer modifyJournal(Integer stdtClsId) {
        return journalMapper.modifyJournal(stdtClsId);
    }

    public Integer deleteJournal(Integer stdtClsId) {
        return journalMapper.deleteJournal(stdtClsId);
    }


}
