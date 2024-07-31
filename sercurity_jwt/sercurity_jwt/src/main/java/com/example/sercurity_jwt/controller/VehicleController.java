package com.example.sercurity_jwt.controller;

import com.example.sercurity_jwt.entity.Vehicle;
import com.example.sercurity_jwt.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public String listAllStudents(Model model) {
        List<Vehicle> vehicles = vehicleService.findAll();
        model.addAttribute("vehicles", vehicles);
        return "vehicle/index";
    }


    @GetMapping("/create")
    public String create(Model model) {
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "vehicle/saveAndPush";
    }

    @PostMapping("/save")
    public String addStudent(@ModelAttribute("student") Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model) {
        Vehicle vehicle = vehicleService.findById(id);
        model.addAttribute("vehicle", vehicle);
        return "vehicle/saveAndPush";
    }

    @GetMapping("/delete")
    public String updateStudent(@RequestParam("id") Long id, Model model) {
        vehicleService.delete(id);
        return "redirect:/vehicles";
    }
}
