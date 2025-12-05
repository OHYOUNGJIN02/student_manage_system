package com.korit.student_manage_system.controller;

import com.korit.student_manage_system.dto.AddClassReqDto;
import com.korit.student_manage_system.dto.ApiRespDto;
import com.korit.student_manage_system.repository.AdminClassRepository;
import com.korit.student_manage_system.service.AdminClassService;
import com.korit.student_manage_system.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")

public class AdminClassController {
    @Autowired
    private AdminClassService adminClassService;

    @Autowired
    private AdminClassRepository adminClassRepository;


    @PostMapping("/addclass")
    public ResponseEntity <?> addClass(@RequestBody AddClassReqDto addClassReqDto) {
        return ResponseEntity.ok(adminClassService.addClass(addClassReqDto));
    }
    @GetMapping("/getList")
    public ResponseEntity<?> getClassList(){
        return ResponseEntity.ok(adminClassService.getClassList());
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteClass(@RequestParam Integer classId){
        return ResponseEntity.ok(adminClassService.deleteClass(classId));
    }


}
