package com.boostmytool.crudImage.service.teacher;

import com.boostmytool.crudImage.enity.Teacher;
import com.boostmytool.crudImage.repository.teacher.TeacherRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService implements TeacherServiceImpl{
    private final TeacherRepository teacherRepository;
    private final EntityManager entityManager;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, EntityManager entityManager) {
        this.teacherRepository = teacherRepository;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Teacher teacher) {
        entityManager.persist(teacher);
    }
}
