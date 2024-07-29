package com.example.sercurity_jwt.service;


import com.example.sercurity_jwt.entity.Members;
import com.example.sercurity_jwt.entity.Role;
import com.example.sercurity_jwt.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Primary
public class MemberService implements IMemberService{
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Members findByName(String username) {
        return memberRepository.findByUsername(username);
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
    public List<Members> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Members findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Members save(Members members) {
        return memberRepository.save(members);
    }

    @Override
    public void update(Members members) {

    }

    @Override
    public void delete(Long id) {
          memberRepository.deleteById(id);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Members members = memberRepository.findByUsername(username);
//        if (members == null) {
//            throw new UsernameNotFoundException("Invalid username and password not found");
//        }
//        return new User(members.getUsername(), members.getPassword(), rolesToAuthorities(members.getRoles()));
//    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Members members = memberRepository.findByUsername(username);
        if (members == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.withUsername(members.getUsername())
                .password(members.getPassword())
                .authorities(members.getRoles().stream().map(role -> role.getName()).toArray(String[]::new))
                .build();
    }
}
