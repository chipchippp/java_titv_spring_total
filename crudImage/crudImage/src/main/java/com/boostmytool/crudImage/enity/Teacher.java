package com.boostmytool.crudImage.enity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_detail_id", referencedColumnName = "id")
    private TeacherDetails teacherDetails;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<Course> courses;
    public Teacher() {
    }

    public Teacher(String name, String email, TeacherDetails teacherDetails) {
        this.name = name;
        this.email = email;
        this.teacherDetails = teacherDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TeacherDetails getTeacherDetails() {
        return teacherDetails;
    }

    public void setTeacherDetails(TeacherDetails teacherDetails) {
        this.teacherDetails = teacherDetails;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void addCourse(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setTeacher(this);
    }
}
