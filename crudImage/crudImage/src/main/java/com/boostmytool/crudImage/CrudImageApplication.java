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
	public CommandLineRunner commandLineRunner(TeacherServiceImpl teacherService, TeacherDetailServiceImpl teacherService1) {
		return args -> {
			createTeacher(teacherService);
		};
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
