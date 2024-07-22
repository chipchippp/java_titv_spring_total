package com.example.securityJpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class Members {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "password")
    private String password;

    @Column(name = "is_active")
    private boolean isActive;


    public Members() {
    }

    public Members(Long userId, String password, boolean isActive) {
        this.userId = userId;
        this.password = password;
        this.isActive = isActive;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
