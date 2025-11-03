package com.colleger.student.student_service.service;

import com.colleger.student.student_service.dto.StudentsDTO;
import com.colleger.student.student_service.model.StudentsEntity;
import com.colleger.student.student_service.repository.IStudentsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentsServiceImpl implements IStudentsService{

    private final IStudentsRepository iStudentsRepository;


    @Override
    public List<StudentsDTO> getAllStudents() {
        List<StudentsEntity> studentsEntity = iStudentsRepository.findAll();
        List<StudentsDTO> studentsDTOList = new ArrayList<>();
        for(StudentsEntity studentsEntity1: studentsEntity){
            StudentsDTO studentsDTO = new StudentsDTO();
            studentsDTO.setId(studentsEntity1.getId());
            studentsDTO.setName(studentsEntity1.getName());
            studentsDTO.setGender(studentsEntity1.getGender());
            studentsDTO.setClassofstudent(studentsEntity1.getClassofstudent());

            studentsDTOList.add(studentsDTO);
        }
        return studentsDTOList;
    }


    @Override
    public String addStudent(StudentsDTO studentsDTO) {
        StudentsEntity studentsEntity = new StudentsEntity();
        studentsEntity.setName(studentsDTO.getName());
        studentsEntity.setGender(studentsDTO.getGender());
        studentsEntity.setClassofstudent(studentsDTO.getClassofstudent());

        iStudentsRepository.save(studentsEntity);
        return "Student Added";
    }

    @Override
    public StudentsDTO updateStudent(Long id, StudentsDTO studentsDTO) {
        StudentsEntity studentsEntity = iStudentsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student does not exist."));
        studentsEntity.setName(studentsDTO.getName());
        studentsEntity.setGender(studentsDTO.getGender());
        studentsEntity.setClassofstudent(studentsDTO.getClassofstudent());
        iStudentsRepository.save(studentsEntity);
        return studentsDTO;
    }

    @Override
    public String deleteStudent(Long id) {
        StudentsEntity studentsEntity;
        studentsEntity = iStudentsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Invalid ID"));
        iStudentsRepository.deleteById(id);
        return studentsEntity.getName() + " is deleted.";
    }


}
