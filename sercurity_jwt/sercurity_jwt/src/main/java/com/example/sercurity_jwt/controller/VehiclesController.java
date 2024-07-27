package com.example.sercurity_jwt.controller;

import com.example.sercurity_jwt.entity.Vehicle;
import com.example.sercurity_jwt.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehiclesController {
    private final VehicleService vehicleService;

    @Autowired
    public VehiclesController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> listAllVehicles() {
        return vehicleService.findAll();
    }

    @PostMapping
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

//    @PutMapping("/{id}")
//    public void updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
//        vehicle.setId(id);
//        vehicleService.update(vehicle);
//    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.delete(id);
    }
}
