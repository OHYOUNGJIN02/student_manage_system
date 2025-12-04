package com.korit.student_manage_system.service;

import com.korit.student_manage_system.dto.ApiRespDto;
import com.korit.student_manage_system.entity.Class;
import com.korit.student_manage_system.mapper.ClassMapper;
import com.korit.student_manage_system.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service

public class ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private ClassRepository classRepository;

    public ApiRespDto<?> getClassList(){
        return new ApiRespDto<>("success", "수업 목록", classMapper.getClassList());
    }

    public ApiRespDto<?> removeClass(Integer classId){
        Optional<Class> foundClass = classRepository.getClassById(classId);
        if(foundClass.isEmpty()){
            return new ApiRespDto<>("failed", "아이디가 없어", null);
        }
        int result = classRepository.deleteClass(foundClass.get().getClsId());
        if(result != 1){
            return new ApiRespDto<>("failed", "삭제하는데 문제 생김", null);
        }
        return new ApiRespDto<>("success", "삭제 성공", null);
    }


}
