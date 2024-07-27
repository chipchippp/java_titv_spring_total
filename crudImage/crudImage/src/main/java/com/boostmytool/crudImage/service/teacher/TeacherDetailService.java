package com.boostmytool.crudImage.service.teacher;

import com.boostmytool.crudImage.enity.Teacher;
import com.boostmytool.crudImage.enity.TeacherDetails;
import com.boostmytool.crudImage.repository.teacher.TeacherRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherDetailService implements TeacherDetailServiceImpl{
    private final TeacherRepository teacherRepository;
    private final EntityManager entityManager;

    @Autowired
    public TeacherDetailService(TeacherRepository teacherRepository, EntityManager entityManager) {
        this.teacherRepository = teacherRepository;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(TeacherDetails teacherDetails) {
        entityManager.persist(teacherDetails);
    }
}
