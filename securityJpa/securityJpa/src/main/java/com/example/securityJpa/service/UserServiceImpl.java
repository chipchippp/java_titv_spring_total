package com.example.securityJpa.service;

import com.example.securityJpa.entity.Role;
import com.example.securityJpa.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserServiceImpl extends UserDetailsService {
//    Role saveRole(Role role);
//    void addRoleToUser(String username, String roleName);
    public UserEntity findByUsername(String username);
    public List<UserEntity> findAll();
    public UserEntity findById(Long id);
    public UserEntity save(UserEntity student);
    public void update(UserEntity student);
    public void delete(Long id);
}
