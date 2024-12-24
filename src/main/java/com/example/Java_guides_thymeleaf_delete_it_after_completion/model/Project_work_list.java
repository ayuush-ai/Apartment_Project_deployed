package com.example.Java_guides_thymeleaf_delete_it_after_completion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity

public class Project_work_list {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String purpose;
    private int apartment_number;
    private LocalDateTime createdAt;




    // Constructor
    public Project_work_list() {
        this.createdAt = LocalDateTime.now(); // Set the current time when the object is created
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getApartment_number() {
        return apartment_number;
    }

    public void setApartment_number(int apartment_number) {
        this.apartment_number = apartment_number;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}