package com.colleger.student.student_service.service;

import com.colleger.student.student_service.dto.StudentsDTO;
import com.colleger.student.student_service.model.StudentsEntity;

import java.util.List;

public interface IStudentsService {

    List<StudentsDTO> getAllStudents();

    String addStudent(StudentsDTO studentsDTO);
}
