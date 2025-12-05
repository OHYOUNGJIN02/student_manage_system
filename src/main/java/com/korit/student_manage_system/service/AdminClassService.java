package com.korit.student_manage_system.service;

import com.korit.student_manage_system.dto.AddClassReqDto;
import com.korit.student_manage_system.dto.ApiRespDto;
import com.korit.student_manage_system.entity.AdminClass;
import com.korit.student_manage_system.mapper.AdminClassMapper;
import com.korit.student_manage_system.repository.AdminClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AdminClassService {

    @Autowired
    private AdminClassMapper adminClassMapper;

    @Autowired
    private AdminClassRepository classRepository;


    public ApiRespDto addClass(AddClassReqDto addClassReqDto) {

        Optional<AdminClass> foundClass = classRepository.getClassByClassName(addClassReqDto.getClsName());
        if (foundClass.isPresent()) {
            return new ApiRespDto<>("failed", "제목이 중복되었습니다.", null);
        }
        Optional<AdminClass> c = classRepository.addClass(addClassReqDto.toEntity());
        if (c.isEmpty()) {
            return new ApiRespDto<>("failed", "추가하는 데에 문제가 발생했습니다.", null);
        }
        return new ApiRespDto<>("success", "게시글 추가 완료", c.get());
    }

    public ApiRespDto<?> getClassList(){
        return new ApiRespDto<>("success", "수업 목록", adminClassMapper.getClassList());
    }

    public ApiRespDto<?> deleteClass(Integer classId){
        Optional<AdminClass> foundClass = classRepository.getClassById(classId);
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
