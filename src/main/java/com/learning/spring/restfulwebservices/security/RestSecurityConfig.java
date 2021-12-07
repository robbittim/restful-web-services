//package com.learning.spring.restfulwebservices.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//@Configuration
//public class RestSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        /**
//         * Disable spring security
//         */
//
//        http.csrf().disable();
//        http.authorizeRequests().antMatchers("/").permitAll();
//        http.headers().frameOptions().disable();
//
//
//    }
//}
