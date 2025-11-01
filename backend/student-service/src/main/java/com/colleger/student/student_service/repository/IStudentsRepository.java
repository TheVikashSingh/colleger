package com.colleger.student.student_service.repository;

import com.colleger.student.student_service.model.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentsRepository extends JpaRepository<StudentsEntity,Long> {
}
