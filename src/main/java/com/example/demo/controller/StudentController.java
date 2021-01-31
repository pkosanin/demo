package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDO;
import com.example.demo.model.StudentDTO;
import com.example.demo.service.StudentService;
import org.hibernate.annotations.OrderBy;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;
    private final ModelMapper mapper;

    public StudentController(final StudentService service,
                             final ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<Collection<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(service.findAll().stream()
                .map(studentDO -> mapper.map(studentDO, StudentDTO.class))
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> addNewStudent(
            @RequestBody final StudentDTO studentDTO) {
        StudentDO studentDO = mapper.map(studentDTO, StudentDO.class);
        System.out.println(studentDO);
        StudentDO responseBody = service.addNewStudent(studentDO);
        return ResponseEntity.ok(mapper.map(responseBody, StudentDTO.class));
    }

}
