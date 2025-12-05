package com.korit.student_manage_system.repository;

import com.korit.student_manage_system.entity.AdminClass;
import com.korit.student_manage_system.mapper.AdminClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class AdminClassRepository {
    @Autowired
    AdminClassMapper adminClassMapper;

    public List<AdminClass>  getAllClass() {
        return adminClassMapper.getClassList();
    }
    public Optional<AdminClass> addClass (AdminClass adminClass) {
        try {
            adminClassMapper.addClass(adminClass);
        }catch (DuplicateKeyException e){
            return Optional.empty();
        }
        return Optional.of(adminClass);
    }

    public int deleteClass (Integer classId) {
        return adminClassMapper.deleteClass(classId);
    }

    public Optional<AdminClass> getClassById(Integer classId) {
        return adminClassMapper.getClassById(classId);
    }

    public Optional <AdminClass> getClassByClassName(String className) {
        return adminClassMapper.getClassByClassName(className);
    }

}
