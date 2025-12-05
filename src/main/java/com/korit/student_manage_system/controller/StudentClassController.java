package com.korit.student_manage_system.controller;

import com.korit.student_manage_system.dto.ApiRespDto;
import com.korit.student_manage_system.dto.JoinClassReqDto;
import com.korit.student_manage_system.entity.StudentClass;
import com.korit.student_manage_system.repository.StudentClassRepository;
import com.korit.student_manage_system.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")

public class StudentClassController {

    @Autowired
    private StudentClassService studentClassService;

    @Autowired
    private StudentClassRepository studentClassRepository;

    @GetMapping("/List")
    public ResponseEntity<?> getStdtClassList(){
        return ResponseEntity.ok(studentClassService.getStdtClassList());
    }

    @PostMapping("/Join")
    public ResponseEntity<?> joinClass(JoinClassReqDto  joinClassReqDto){
        return ResponseEntity.ok(studentClassService.joinClass(joinClassReqDto));
    }

    @PostMapping("/Cancel")
    public ResponseEntity<?> cancelClass(@RequestParam Integer classId){
        return ResponseEntity.ok(studentClassService.cancelClass(classId));
    }
}
