package com.boostmytool.crudImage.service.teacher;

import com.boostmytool.crudImage.enity.Teacher;

public interface TeacherServiceImpl {
    public void save(Teacher teacher);
    public Teacher findById(Long id);
    public void update(Teacher teacher);
    public void deleteById(Long id);
    public Teacher findTeacherByIdJoinFetch(Long id);
}
