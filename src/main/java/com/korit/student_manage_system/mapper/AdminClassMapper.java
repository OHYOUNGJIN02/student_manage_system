package com.korit.student_manage_system.mapper;

import com.korit.student_manage_system.entity.AdminClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper

public interface AdminClassMapper {
    List<AdminClass> getClassList ();
    void addClass (AdminClass c);
    int deleteClass (Integer classId);
    Optional<AdminClass> getClassById(Integer classId);
    Optional <AdminClass> getClassByClassName(String className);
}
