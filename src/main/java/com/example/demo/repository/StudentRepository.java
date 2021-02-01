package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.Student;

import java.util.Collection;

public interface StudentRepository {

    Collection<Student> findAll();

    Student createStudent(Student student);

    Book addBookToStudent(long id, Book book);
}
