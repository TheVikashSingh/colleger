package com.colleger.student.student_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "studentstable")
@Data
public class StudentsEntity {

    @Id
    private final Long id = (new IDGenerator()).getId();

    @NotEmpty
    private String name;

    @NotEmpty
    private String gender;

    @Column(name = "class_of_student")
    private String classofstudent;

}
