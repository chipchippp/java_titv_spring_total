package com.example.sercurity_jwt.service;

import com.example.sercurity_jwt.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public UserEntity findByName(String username);
    public List<UserEntity> findAll();
    public UserEntity findById(Long id);
    public UserEntity save(UserEntity userEntity);
    public void update(UserEntity userEntity);
    public void delete(Long id);
}
