package com.boostmytool.crudImage.repository.teacher;


import com.boostmytool.crudImage.enity.TeacherDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDetailRepository extends JpaRepository<TeacherDetails, Long> {

}
