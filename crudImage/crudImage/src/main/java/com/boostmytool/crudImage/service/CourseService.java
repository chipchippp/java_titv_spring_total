package com.boostmytool.crudImage.service;

import com.boostmytool.crudImage.enity.Course;
import com.boostmytool.crudImage.enity.Teacher;
import com.boostmytool.crudImage.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService implements CourseServiceImpl{
    private final CourseRepository courseRepository;
    private final EntityManager entityManager;

    @Autowired
    public CourseService(CourseRepository courseRepository, EntityManager entityManager) {
        this.courseRepository = courseRepository;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<Course> findCourseByTeacherId(Long id) {
//        Teacher teacher = entityManager.find(Teacher.class, id);
//        return teacher.getCourses();

        TypedQuery query = entityManager.createQuery(
                "SELECT c FROM Course c WHERE c.teacher.id = :x", Course.class);
        query.setParameter("x", id);

        List<Course> courses = query.getResultList();
        return courses;
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).get();
    }
}
