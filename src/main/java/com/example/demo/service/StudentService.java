package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDO;
import com.example.demo.model.StudentDTO;

import java.util.Collection;

public interface StudentService {

    Collection<StudentDO> findAll();

    StudentDO addNewStudent(StudentDO studentDO);
}
