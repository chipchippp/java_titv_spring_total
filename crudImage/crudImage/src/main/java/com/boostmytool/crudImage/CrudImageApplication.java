package com.boostmytool.crudImage;

import com.boostmytool.crudImage.enity.Teacher;
import com.boostmytool.crudImage.enity.TeacherDetails;
import com.boostmytool.crudImage.service.teacher.TeacherDetailService;
import com.boostmytool.crudImage.service.teacher.TeacherDetailServiceImpl;
import com.boostmytool.crudImage.service.teacher.TeacherService;
import com.boostmytool.crudImage.service.teacher.TeacherServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudImageApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudImageApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TeacherServiceImpl teacherService, TeacherDetailServiceImpl teacherDetailService) {
		return args -> {
//			createTeacher(teacherService);
//			findTeacherById(teacherService, 1);
//			findTeacherDetailById(teacherDetailService, 1);

			deleteTeacherById(teacherService, 1);
		};
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
//		teacherDetail.setDateOfBirth("1999-01-01");
		teacherDetail.setPhone("0123456789");
		teacherDetail.setGender(true);

//		Associate the objects
		teacher.setTeacherDetails(teacherDetail);

		System.out.printf("Teacher: %s\n", teacher);
		teacherService.save(teacher);
		System.out.printf("Done!");

	}
}
