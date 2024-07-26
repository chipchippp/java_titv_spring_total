//package com.boostmytool.crudImage.controller;
//
//
//import com.example.spring_mvc.entity.Student;
//import com.example.spring_mvc.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
////@RestController
//@Controller
//@RequestMapping("/students")
//public class StudentController {
//    private final StudentService studentService;
//
//    @Autowired
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    @GetMapping
//    public String listAllStudents(Model model) {
//        List<Student> students = studentService.findAll();
//        model.addAttribute("students", students);
//        return "student/index";
//    }
//
//
//    @GetMapping("/create")
//    public String create(Model model) {
//        Student student = new Student();
//        model.addAttribute("student", student);
//        return "student/saveAndPush";
//    }
//
//    @PostMapping("/save")
//    public String addStudent(@ModelAttribute("student") Student student) {
//        studentService.save(student);
//        return "redirect:/students";
//    }
//
//    @GetMapping("/update")
//    public String update(@RequestParam("id") Long id, Model model) {
//        Student student = studentService.findById(id);
//        model.addAttribute("student", student);
//        return "student/saveAndPush";
//    }
//
//    @GetMapping("/delete")
//    public String updateStudent(@RequestParam("id") Long id, Model model) {
//        studentService.delete(id);
//        return "redirect:/students";
//    }
//}
