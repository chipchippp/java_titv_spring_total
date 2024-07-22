package com.example.securityJpa.security;

import com.example.securityJpa.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableAutoConfiguration
public class SecurityConfiguration {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(UserService userService){
        DaoAuthenticationProvider daoAuthentication = new DaoAuthenticationProvider();
        daoAuthentication.setUserDetailsService(userService);
        daoAuthentication.setPasswordEncoder(passwordEncoder());
        return daoAuthentication;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/register/**").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/loginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout")
                                .permitAll()
                )
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling.accessDeniedPage("/showPage403")
                );
        return http.build();
    }
}
