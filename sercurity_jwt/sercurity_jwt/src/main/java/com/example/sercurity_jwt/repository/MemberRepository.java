package com.example.sercurity_jwt.repository;


import com.example.sercurity_jwt.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Members, Long> {
    public Members findByUsername(String username);
}
