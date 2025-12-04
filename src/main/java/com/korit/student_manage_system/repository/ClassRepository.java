package com.korit.student_manage_system.repository;

import com.korit.student_manage_system.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class ClassRepository {
    @Autowired
    ClassMapper classMapper;

    public List<Class>  getAllClass() {
        return classMapper.getClassList();
    }
    public Optional<Class> addClass (Class c) {
        try {
            classMapper.addClass(c);
        }catch (DuplicateKeyException e){
            return Optional.empty();
        }
        return Optional.of(c);
    }

    public int deleteClass (Integer classId) {
        return classMapper.deleteClass(classId);
    }

    public Optional<com.korit.student_manage_system.entity.Class> getClassById(Integer classId) {
        return classMapper.getClassById(classId);
    }


}
