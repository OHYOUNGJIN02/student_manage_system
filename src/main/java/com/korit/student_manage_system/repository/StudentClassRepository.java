package com.korit.student_manage_system.repository;

import com.korit.student_manage_system.entity.StudentClass;
import com.korit.student_manage_system.mapper.StudentClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class StudentClassRepository {
    @Autowired
    StudentClassMapper studentClassMapper;

    public List<StudentClass> getAllClass() {
        return studentClassMapper.getStdtClassList();
    }
    public Optional<StudentClass> joinClass (StudentClass studentClass) {
        try {
            studentClassMapper.joinClass(studentClass);
        }catch (DuplicateKeyException e){
            return Optional.empty();
        }
        return Optional.of(studentClass);
    }

    public int cancelClass (Integer classId) {
        return studentClassMapper.cancelClass(classId);
    }

    public Optional<StudentClass> getClassById(Integer classId) {
        return studentClassMapper.getClassById(classId);
    }

}