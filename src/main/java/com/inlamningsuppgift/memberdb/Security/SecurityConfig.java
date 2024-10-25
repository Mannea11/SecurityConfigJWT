 package com.inlamningsuppgift.memberdb.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

 @Configuration
 @EnableWebSecurity
 @EnableMethodSecurity
public class SecurityConfig {

     @Autowired
     private JwtAuthConverter jwtAuthConverter;

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
         http.httpBasic(Customizer.withDefaults());
         http.csrf(csrf -> csrf.disable());

         http
                 .csrf()
                 .disable()
                 .authorizeHttpRequests()
                 .anyRequest()
                 .authenticated();

         http
                 .oauth2ResourceServer()
                 .jwt()
                 .jwtAuthenticationConverter(jwtAuthConverter);


         http
                 .sessionManagement()
                 .sessionCreationPolicy(STATELESS);
         return http.build();
     }
 }