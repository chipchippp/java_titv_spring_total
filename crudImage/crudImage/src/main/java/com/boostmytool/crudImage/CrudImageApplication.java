package com.boostmytool.crudImage;

import com.boostmytool.crudImage.enity.Course;
import com.boostmytool.crudImage.enity.Teacher;
import com.boostmytool.crudImage.enity.TeacherDetails;
import com.boostmytool.crudImage.service.CourseService;
import com.boostmytool.crudImage.service.teacher.TeacherDetailServiceImpl;
import com.boostmytool.crudImage.service.teacher.TeacherServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CrudImageApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudImageApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TeacherServiceImpl teacherService, TeacherDetailServiceImpl teacherDetailService, CourseService courseService) {
		return args -> {
//			createTeacher(teacherService);
//			findTeacherById(teacherService, 1);
//			findTeacherDetailById(teacherDetailService, 1);
//			deleteTeacherById(teacherService, 1);
			
			createCourse(teacherService, courseService);
		};
	}

	private void createCourse(TeacherServiceImpl teacherService, CourseService courseService) {
		Teacher teacher = new Teacher();
		teacher.setName("Nvl");
		teacher.setEmail("nvl@gmail.com");

		TeacherDetails teacherDetail = new TeacherDetails();
		teacherDetail.setPhone("0123456");
		teacherDetail.setGender(true);
		teacher.setTeacherDetails(teacherDetail);

		List<Course> courses = new ArrayList<>();
		Course course1 = new Course("Spring Boot", "des", null, null);
		Course course2 = new Course("Fullstack and Spring Boot", "des", null, null);

		teacher.addCourse(course1);
		teacher.addCourse(course2);

		System.out.println("Update teacher");
		teacherService.update(teacher);
		System.out.println("Done!");
	}

	private void deleteTeacherById(TeacherServiceImpl teacherService, int i) {
		teacherService.deleteById((long) i);
		System.out.printf("Done!");
	}

	private void findTeacherDetailById(TeacherDetailServiceImpl teacherDetailService, int i) {
		TeacherDetails teacherDetails = teacherDetailService.findById((long) i);
		System.out.printf("Teacher Details: %s\n", teacherDetails);
		System.out.printf("Teacher: %s\n", teacherDetails.getTeacher());
	}

	private void findTeacherById(TeacherServiceImpl teacherService, int i) {
		Teacher teacher = teacherService.findById((long) i);
		System.out.printf("Teacher: %s\n", teacher);
		System.out.printf("Teacher Details: %s\n", teacher.getTeacherDetails());


	}

	private void createTeacher(TeacherServiceImpl teacherService) {
		Teacher teacher = new Teacher();
		teacher.setName("John");
		teacher.setEmail("nvl@gmail.com");

		TeacherDetails teacherDetail = new TeacherDetails();
		teacherDetail.setPhone("0123456789");
		teacherDetail.setGender(true);

//		Associate the objects
		teacher.setTeacherDetails(teacherDetail);

		System.out.printf("Teacher: %s\n", teacher);
		teacherService.save(teacher);
		System.out.printf("Done!");

	}
}
