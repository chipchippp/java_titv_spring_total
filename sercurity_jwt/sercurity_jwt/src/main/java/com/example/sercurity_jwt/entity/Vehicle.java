package com.example.sercurity_jwt.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    @Column(name = "vehicle_name", nullable = false, length = 64)
    private String vehicleName;

    @Column(name = "vehicle_model", nullable = false, length = 10)
    private String vehicleModel;

    @Column(name = "year_of_manufacture", nullable = false)
    private int yearOfManufacture;

    @Column(name = "vehicle_color", length = 16)
    private String vehicleColor;

    // Constructors, getters, and setters

    public Vehicle() {
    }

    public Vehicle(String vehicleName, String vehicleModel, int yearOfManufacture, String vehicleColor) {
        this.vehicleName = vehicleName;
        this.vehicleModel = vehicleModel;
        this.yearOfManufacture = yearOfManufacture;
        this.vehicleColor = vehicleColor;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }
}
