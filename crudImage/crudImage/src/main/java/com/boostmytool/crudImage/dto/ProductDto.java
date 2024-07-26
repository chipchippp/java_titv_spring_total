package com.boostmytool.crudImage.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class ProductDto {
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Brand is required")
    private String brand;
    @NotEmpty(message = "Category is required")
    private String category;
    @Min(value = 0, message = "Price must be greater than 0")
    private double price;
    @Size(min = 10, message = "Description must be at least 10 characters long")
    @Size(max = 1000, message = "Description must be less than 1000 characters long")
    private String description;

//    private Date createdAt;
    private MultipartFile imageFile;

    public ProductDto() {
    }

    public ProductDto(String name, String brand, String category, double price, String description, MultipartFile imageFile) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.description = description;
        this.imageFile = imageFile;
    }

    public @NotEmpty(message = "Name is required") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Name is required") String name) {
        this.name = name;
    }

    public @NotEmpty(message = "Brand is required") String getBrand() {
        return brand;
    }

    public void setBrand(@NotEmpty(message = "Brand is required") String brand) {
        this.brand = brand;
    }

    public @NotEmpty(message = "Category is required") String getCategory() {
        return category;
    }

    public void setCategory(@NotEmpty(message = "Category is required") String category) {
        this.category = category;
    }

    @Min(value = 0, message = "Price must be greater than 0")
    public double getPrice() {
        return price;
    }

    public void setPrice(@Min(value = 0, message = "Price must be greater than 0") double price) {
        this.price = price;
    }

    public @Size(min = 10, message = "Description must be at least 10 characters long") @Size(max = 1000, message = "Description must be less than 1000 characters long") String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 10, message = "Description must be at least 10 characters long") @Size(max = 1000, message = "Description must be less than 1000 characters long") String description) {
        this.description = description;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}
