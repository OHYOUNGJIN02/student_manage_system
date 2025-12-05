package com.korit.student_manage_system.service;

import com.korit.student_manage_system.dto.AddClassReqDto;
import com.korit.student_manage_system.dto.ApiRespDto;
import com.korit.student_manage_system.dto.JoinClassReqDto;
import com.korit.student_manage_system.entity.AdminClass;
import com.korit.student_manage_system.entity.StudentClass;
import com.korit.student_manage_system.mapper.StudentClassMapper;
import com.korit.student_manage_system.repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class StudentClassService {
    @Autowired
    StudentClassMapper studentClassMapper;
    @Autowired
    StudentClassRepository studentClassRepository;

    public ApiRespDto joinClass(JoinClassReqDto joinClassReqDto) {

        Optional<StudentClass> studentClass = studentClassRepository.getClassById(joinClassReqDto.getClsId());
        if (studentClass.isEmpty()) {
            return new ApiRespDto<>("failed", "없다.", null);
        }
        return new ApiRespDto<>("success", "참가 완료", studentClass.get());
    }

    public ApiRespDto<?> getStdtClassList(){
        return new ApiRespDto<>("success", "수업 목록", studentClassMapper.getStdtClassList());
    }

    public ApiRespDto<?> cancelClass(Integer classId){
        Optional<StudentClass> foundClass = studentClassRepository.getClassById(classId);
        if(foundClass.isEmpty()){
            return new ApiRespDto<>("failed", "아이디가 없어", null);
        }
        int result = studentClassRepository.cancelClass(foundClass.get().getClsId());
        if(result != 1){
            return new ApiRespDto<>("failed", "삭제하는데 문제 생김", null);
        }
        return new ApiRespDto<>("success", "삭제 성공", null);
    }
}
