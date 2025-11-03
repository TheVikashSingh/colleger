package com.colleger.caretaker.caretaker_service.service;

import com.colleger.student.student_service.dto.StudentsDTO;

import java.util.List;

public interface IStudentsService {

    List<StudentsDTO> getAllStudents();

    String addStudent(StudentsDTO studentsDTO);

    StudentsDTO updateStudent(Long id, StudentsDTO studentsDTO);

    String deleteStudent(Long id);
}
