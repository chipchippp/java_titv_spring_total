package com.boostmytool.crudImage.service.student;

import com.boostmytool.crudImage.enity.Course;
import com.boostmytool.crudImage.enity.Student;
import com.boostmytool.crudImage.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student findStudentAndCourseByStudentId(Long id) {
        TypedQuery<Student> query = entityManager.createQuery(
                "SELECT s FROM Student s " +
                        "JOIN FETCH s.courses " +
                        "WHERE s.id = :x", Student.class);
        query.setParameter("x", id);

        List<Student> students = query.getResultList();
        return students.get(0);
    }

}
