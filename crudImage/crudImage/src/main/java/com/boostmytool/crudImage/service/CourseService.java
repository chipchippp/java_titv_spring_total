package com.boostmytool.crudImage.service;

import com.boostmytool.crudImage.enity.Course;
import com.boostmytool.crudImage.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService implements CourseServiceImpl{
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).get();
    }
}
