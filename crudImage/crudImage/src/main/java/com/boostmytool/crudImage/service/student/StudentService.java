package com.boostmytool.crudImage.service.student;

import com.boostmytool.crudImage.enity.Student;
import com.boostmytool.crudImage.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService{
    private final EntityManager entityManager;
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(EntityManager entityManager, StudentRepository studentRepository) {
        this.entityManager = entityManager;
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }
}
