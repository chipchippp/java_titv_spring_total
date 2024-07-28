package com.boostmytool.crudImage.service.teacher;

import com.boostmytool.crudImage.enity.Course;
import com.boostmytool.crudImage.enity.Teacher;
import com.boostmytool.crudImage.enity.TeacherDetails;
import com.boostmytool.crudImage.repository.teacher.TeacherRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Teacher findById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    @Transactional
    public void update(Teacher teacher) {
        entityManager.merge(teacher);
        entityManager.flush();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        entityManager.remove(teacher);
    }

    @Override
    public Teacher findTeacherByIdJoinFetch(Long id) {
        TypedQuery query = entityManager.createQuery(
                "SELECT t FROM Teacher t " +
                        "JOIN FETCH t.courses " +
                        "JOIN FETCH t.teacherDetails " +
                        "WHERE t.id = :x", Teacher.class);
        query.setParameter("x", id);

        Teacher teacher = (Teacher) query.getSingleResult();
        return teacher;

    }
}
