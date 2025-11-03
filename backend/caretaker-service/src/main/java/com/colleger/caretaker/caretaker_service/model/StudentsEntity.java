package com.colleger.caretaker.caretaker_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "studentsdb")
@Data
public class StudentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String sex;

    @Column(name = "class_of_student")
    private String classofstudent;

}
