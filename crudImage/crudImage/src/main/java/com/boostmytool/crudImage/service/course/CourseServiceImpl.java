package com.boostmytool.crudImage.service.course;

import com.boostmytool.crudImage.enity.Course;

import java.util.List;

public interface CourseServiceImpl {
    public void saveCourse(Course course);
    public List<Course> findCourseByTeacherId(Long id);

}
