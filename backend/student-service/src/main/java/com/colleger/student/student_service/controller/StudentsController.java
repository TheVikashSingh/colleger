package com.colleger.student.student_service.controller;


import com.colleger.student.student_service.dto.StudentsDTO;
import com.colleger.student.student_service.service.StudentsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students/")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StudentsController {

    private final StudentsServiceImpl studentsService;

    @GetMapping
    public List<StudentsDTO> getStudents(){
        return studentsService.getAllStudents();
    }

    @PostMapping
    public String addStudent(@RequestBody StudentsDTO studentsDTO){
        return studentsService.addStudent(studentsDTO);
    }

    @PutMapping("{id}")
    public StudentsDTO updateStudent(@PathVariable Long id, @RequestBody StudentsDTO studentsDTO){
        return studentsService.updateStudent(id, studentsDTO);
    }

    @DeleteMapping("{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentsService.deleteStudent(id);
    }

}
