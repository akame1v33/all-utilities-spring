//package com.myallutilities.utilities.config;
//
//
//import com.oauth2.server.server.service.CustomUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private CustomUserDetailService customUserDetailService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .anonymous()
//                .disable()
//                .httpBasic()
//                .and()
//                .csrf().disable()
//                .formLogin().disable()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated();
//
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.userDetailsService(customUserDetailService)
//                .passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//
//
//
//
//
//
//
//
//
////    @Autowired
////    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
////        auth
////                .userDetailsService(customUserDetailService)
////                .passwordEncoder(passwordEncoder());
////    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//
//}
