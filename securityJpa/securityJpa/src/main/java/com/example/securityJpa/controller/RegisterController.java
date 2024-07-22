//package com.example.securityJpa.controller;
//
//import com.example.securityJpa.entity.UserEntity;
//import com.example.securityJpa.service.UserService;
//import com.example.securityJpa.web.RegisterUser;
//import jakarta.servlet.http.HttpSession;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/register")
//public class RegisterController {
//    private final UserService userService;
//
//    @Autowired
//    public RegisterController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public String register(Model model) {
//        RegisterUser registerUser = new RegisterUser();
//        model.addAttribute("registerUser", registerUser);
//        return "account/register";
//    }
//
//    @PostMapping("/process")
//    public String process(@Valid @ModelAttribute("registerUser") RegisterUser registerUser,
//                          Model model,
//                          BindingResult result,
//                          HttpSession session
//    ) {
//        String username = registerUser.getUsername();
//        if (result.hasErrors()) {
//            return "account/register";
//        }
////        Kiểm tra xem user đã tồn tại chưa
//        UserEntity user = userService.findByUsername(username);
//        if (user != null) {
//            model.addAttribute("registerUser", new RegisterUser());
//            model.addAttribute("message", "User already exists");
//            return "account/register";
//        }
////        Mã hóa password, nếu chưa tồn tại thì lưu
//        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
//        user = new UserEntity();
//        user.setUsername(registerUser.getUsername());
//        user.setEmail(registerUser.getEmail());
//        user.setPassword(bCrypt.encode(registerUser.getPassword()));
//        userService.save(user);
//
////        thông báo đăng ký thành công
//        session.setAttribute("myUser", user);
//        return "redirect:/login";
//    }
//}
