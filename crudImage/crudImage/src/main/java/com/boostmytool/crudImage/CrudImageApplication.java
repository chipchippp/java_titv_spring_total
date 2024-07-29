package com.boostmytool.crudImage;

import com.boostmytool.crudImage.enity.Course;
import com.boostmytool.crudImage.enity.Student;
import com.boostmytool.crudImage.enity.Teacher;
import com.boostmytool.crudImage.enity.TeacherDetails;
import com.boostmytool.crudImage.service.course.CourseService;
import com.boostmytool.crudImage.service.student.StudentService;
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
	public CommandLineRunner commandLineRunner(
			TeacherServiceImpl teacherService,
			TeacherDetailServiceImpl teacherDetailService,
			CourseService courseService,
			StudentService studentService
	) {
		return args -> {
//			createTeacher(teacherService);
//			findTeacherById(teacherService, 1);
//			findTeacherDetailById(teacherDetailService, 1);
//			deleteTeacherById(teacherService, 1);
//			createCourse(teacherService, courseService);

//			findTeacherWithCourse_Eager(teacherService, 1);
//			findTeacherWithCourse_Eager(teacherService, 2);

//			findTeacherWithCourse_Lazy(teacherService, courseService, 1);
//			findTeacherWithCourse_Lazy_JoinFetch(teacherService, 1);

//			createCourseAndStudent(courseService, studentService);

			findCourseAndStudent(courseService, studentService, 1L);

		};
	}

	private void findCourseAndStudent(CourseService courseService, StudentService studentService, Long id) {
		Course course = courseService.findCourseByStudentId(id);
		if (course != null) {
			System.out.println("Course found!");
			System.out.printf("Course: %s\n", course);

//			Student student = studentService.findStudentAndCourseByStudentId(id);
//			System.out.printf("Student: %s\n", student);

			System.out.printf("List of Students: %s\n", course.getStudents());
		} else {
			System.out.println("No course found with ID: " + id);
		}
	}

	private void createCourseAndStudent(CourseService courseService, StudentService studentService) {
		Course course = new Course();
		course.setTitle("Spring Boot");

		Student student = new Student("Nvl", "nvl@gmail.com");
		Student student2 = new Student("John", "john@gmail.com");
		course.addStudent(student);
		course.addStudent(student2);

		courseService.saveCourse(course);
	}

	private void findTeacherWithCourse_Lazy_JoinFetch(TeacherServiceImpl teacherService, int i) {
		Teacher teacher = teacherService.findTeacherByIdJoinFetch((long) i);
		if (teacher != null) {
			System.out.println("Teacher found!");
			System.out.printf("Teacher: %s\n", teacher);

//			print courses
			System.out.printf("List of Courses: %s\n", teacher.getCourses());
		} else {
			System.out.println("No teacher found with ID: " + i);
		}
	}

	private void findTeacherWithCourse_Lazy(TeacherServiceImpl teacherService, CourseService courseService, int i) {
		Teacher teacher = teacherService.findById((long) i);
		if (teacher != null) {
			System.out.println("Teacher found!");
			System.out.printf("Teacher: %s\n", teacher);
//			select courses
			List<Course> courses = courseService.findCourseByTeacherId((long) i);
			teacher.setCourses(courses);
//			print courses
			System.out.printf("List of Courses: %s\n", teacher.getCourses());
		} else {
			System.out.println("No teacher found with ID: " + i);
		}
	}

	private void findTeacherWithCourse_Eager(TeacherServiceImpl teacherService, int i) {
		Teacher teacher = teacherService.findById((long) i);
		if (teacher != null) {
			System.out.println("Teacher found!");
			System.out.printf("Teacher: %s\n", teacher);
			System.out.printf("List of Courses: %s\n", teacher.getCourses());
		} else {
			System.out.println("No teacher found with ID: " + i);
		}
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
