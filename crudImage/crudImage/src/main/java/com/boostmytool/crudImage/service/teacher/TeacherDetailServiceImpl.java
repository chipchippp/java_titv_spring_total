package com.boostmytool.crudImage.service.teacher;


import com.boostmytool.crudImage.enity.TeacherDetails;

public interface TeacherDetailServiceImpl {
    public void save(TeacherDetails teacherDetails);
    public TeacherDetails findById(Long id);
    public void deleteById(Long id);
}
