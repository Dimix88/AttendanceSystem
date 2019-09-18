package com.dimitri.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AttendanceSystemSecurity extends WebSecurityConfigurerAdapter {

    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

            auth
                    .inMemoryAuthentication()
                    .withUser("user")
                    .password(encoder().encode("password"))
                    .roles(USER_ROLE)
                    .and()
                    .withUser("admin")
                    .password(encoder().encode("admin"))
                    .roles(USER_ROLE,ADMIN_ROLE);


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"AttendanceSystem/create**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET,"AttendanceSystem/getall").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.DELETE,"AttendanceSystem/delete**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PUT,"AttendanceSystem/update**").hasRole(ADMIN_ROLE)
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
