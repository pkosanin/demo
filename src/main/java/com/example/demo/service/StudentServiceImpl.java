package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.BookDO;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDO;
import com.example.demo.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository repository;
    private final ModelMapper mapper;

    public StudentServiceImpl(final StudentRepository repository,
                              final ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Collection<StudentDO> findAll() {
        return repository.findAll().stream()
                .map(student -> mapper.map(student, StudentDO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDO addNewStudent(final StudentDO studentDO) {
        Student student = mapper.map(studentDO, Student.class);
        return mapper.map(repository.createStudent(student), StudentDO.class);
    }

    @Override
    public BookDO addNewBookToStudent(long id, final BookDO bookDO) {
        Book book = mapper.map(bookDO, Book.class);
        return mapper.map(repository.addBookToStudent(id, book), BookDO.class);
    }
}
