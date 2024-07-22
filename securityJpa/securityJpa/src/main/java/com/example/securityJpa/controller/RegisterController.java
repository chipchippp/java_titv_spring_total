package com.example.securityJpa.controller;

import com.example.securityJpa.entity.Role;
import com.example.securityJpa.entity.UserEntity;
import com.example.securityJpa.repository.RoleRepository;
import com.example.securityJpa.service.UserService;
import com.example.securityJpa.web.RegisterUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;
    private final RoleRepository roleRepository;

    @Autowired
    public RegisterController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping
    public String register(Model model) {
        RegisterUser registerUser = new RegisterUser();
        model.addAttribute("registerUser", registerUser);
        return "account/register";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/process")
    public String process(@Valid @ModelAttribute("registerUser") RegisterUser registerUser,
                          BindingResult result,
                          Model model,
                          HttpSession session) {
        String username = registerUser.getUsername();
        if (result.hasErrors()) {
            return "account/register";
        }
        // Kiểm tra xem user đã tồn tại chưa
        UserEntity user = userService.findByUsername(username);
        if (user != null) {
            model.addAttribute("registerUser", new RegisterUser());
            model.addAttribute("my_error", "User already exists");
            return "account/register";
        }
        // Mã hóa password, nếu chưa tồn tại thì lưu
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        user = new UserEntity();
        user.setUsername(registerUser.getUsername());
        user.setEmail(registerUser.getEmail());
        user.setPassword(bCrypt.encode(registerUser.getPassword()));
        userService.save(user);

        // Mặc định user đăng ký sẽ là manager
        Role role = roleRepository.findByName("ROLE_MANAGER");
        Collection<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);

        // Thông báo đăng ký thành công
        session.setAttribute("myUser", user);
        return "redirect:/login";
    }
}

