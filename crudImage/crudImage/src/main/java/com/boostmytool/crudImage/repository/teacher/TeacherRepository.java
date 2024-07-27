package com.boostmytool.crudImage.repository.teacher;


import com.boostmytool.crudImage.enity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
