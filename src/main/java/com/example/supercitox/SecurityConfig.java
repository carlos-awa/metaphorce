package com.example.supercitox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity,
                                    AuthenticationManager authenticationManager) throws Exception {

        return httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/v3/api-docs/*", "/swagger-ui/*", "/swagger-ui.html").permitAll()
                .requestMatchers("usuario/mostrarUsuarios").hasRole("admin")
                .requestMatchers("usuario/agregarUsuario").hasRole("admin")
                .requestMatchers("usuario/actualizarUsuario").hasRole("admin")
                .requestMatchers("usuario/borrarUsuario/**").hasRole("admin")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .build();

    }

    @Bean
    UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin1").password(passwordEncoder().encode("1234")).roles("admin").build());
        return manager;
    }

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity httpSecurity,
                                                PasswordEncoder passwordEncoder) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    } //close method


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
