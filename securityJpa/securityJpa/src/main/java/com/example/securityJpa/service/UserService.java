package com.example.securityJpa.service;

import com.example.securityJpa.entity.Role;
import com.example.securityJpa.entity.UserEntity;
import com.example.securityJpa.repository.RoleRepository;
import com.example.securityJpa.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceImpl{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

//    @PostConstruct
//    public void insertUser() {
//        Role role = new Role();
//        role.setName("ROLE_MANAGER");
//
//        UserEntity admin = new UserEntity();
//        admin.setUsername("manager");
//        admin.setEmail("manager@gmail.com");
//        admin.setPassword("{bcrypt}$2a$12$T7dlKj5bvupqA6OKk8VtQuNWUoLuOU92zYWsT1Nd8PCvf2HKd1X22");
//        admin.setEnabled(true);
//
//        Collection<Role> roles = new ArrayList<>();
//        roles.add(role);
//        admin.setRoles(roles);
//
//        userRepository.save(admin);
//    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserEntity> findAll() {
      return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username and password not found");
        }
        return new User(user.getUsername(), user.getPassword(), rolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
    @Override
    public UserEntity findById(Long id) {
        return null;
    }

    @Override
    public UserEntity save(UserEntity student) {
        return null;
    }

    @Override
    public void update(UserEntity student) {

    }

    @Override
    public void delete(Long id) {

    }
}
