package com.example.sercurity_jwt.service;



import com.example.sercurity_jwt.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    public List<Vehicle> findAll();
    public Vehicle findById(Long id);
    public Vehicle save(Vehicle vehicle);
    public void update(Vehicle vehicle);
    public void delete(Long id);
}
