package com.korit.student_manage_system.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper

public interface ClassMapper {
    List<Class> getClassList ();
    void addClass (Class c);
    int deleteClass (Integer classId);
    Optional<com.korit.student_manage_system.entity.Class> getClassById(Integer classId);
}
