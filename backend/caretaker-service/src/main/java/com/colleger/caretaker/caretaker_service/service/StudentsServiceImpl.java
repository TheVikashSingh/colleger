package com.colleger.caretaker.caretaker_service.service;

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
            studentsDTO.setSex(studentsEntity1.getSex());
            studentsDTO.setClassofstudent(studentsEntity1.getClassofstudent());

            studentsDTOList.add(studentsDTO);
        }
        return studentsDTOList;
    }


    @Override
    public String addStudent(StudentsDTO studentsDTO) {
        StudentsEntity studentsEntity = new StudentsEntity();
        studentsEntity.setName(studentsDTO.getName());
        studentsEntity.setSex(studentsDTO.getSex());
        studentsEntity.setClassofstudent(studentsDTO.getClassofstudent());

        iStudentsRepository.save(studentsEntity);
        return "Student Added";
    }

    @Override
    public StudentsDTO updateStudent(Long id, StudentsDTO studentsDTO) {
        if(!iStudentsRepository.existsById(id)){
            throw new RuntimeException("Id does not exist");
        }
        StudentsEntity studentsEntity = iStudentsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student does not exist."));
        studentsEntity.setName(studentsDTO.getName());
        studentsEntity.setSex(studentsDTO.getName());
        studentsEntity.setClassofstudent(studentsDTO.getClassofstudent());
        iStudentsRepository.save(studentsEntity);
        return studentsDTO;
    }

    @Override
    public String deleteStudent(Long id) {
        StudentsEntity studentsEntity;
        if(!iStudentsRepository.existsById(id)){
            throw new RuntimeException("Invalid id");
        }
        studentsEntity = iStudentsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Invalid ID"));
        iStudentsRepository.deleteById(id);
        return studentsEntity.getName() + " is deleted.";
    }


}
