package com.example.sercurity_jwt.service;


import com.example.sercurity_jwt.entity.Members;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IMemberService extends UserDetailsService {
    public Members findByName(String username);
    public List<Members> findAll();
    public Members findById(Long id);
    public Members save(Members members);
    public void update(Members members);
    public void delete(Long id);
}
