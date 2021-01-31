package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class StudentRepositoryImpl implements StudentRepository{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<Student> findAll() {
        return entityManager
                .createQuery("from Student", Student.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Student createStudent(final Student student) {
        System.out.println(student);
        entityManager.persist(student);
        return student;
    }
}
