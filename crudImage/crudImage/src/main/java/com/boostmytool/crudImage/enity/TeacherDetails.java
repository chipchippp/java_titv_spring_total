package com.boostmytool.crudImage.enity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "teacher_detail")
public class TeacherDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "phone")
    private String phone;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "gender")
    private boolean gender;

    @OneToOne(mappedBy = "teacherDetails", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Teacher teacher;

    public TeacherDetails() {
    }

    public TeacherDetails(Long id, String phone, Date dateOfBirth, boolean gender) {
        this.id = id;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "TeacherDetails{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", teacher=" + teacher +
                '}';
    }
}
