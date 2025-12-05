package com.korit.student_manage_system.mapper;

import com.korit.student_manage_system.entity.StudentClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper

public interface StudentClassMapper {
    List<StudentClass> getStdtClassList ();
    void joinClass (StudentClass studentClass);
    int cancelClass (Integer clsId);
    Optional<StudentClass> getClassById(Integer clsId);
    Optional <StudentClass> getClassByClassName(String clsName);


}
