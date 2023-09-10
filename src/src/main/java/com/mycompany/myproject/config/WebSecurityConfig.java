package com.mycompany.myproject.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll();
                .anyRequest().permitAll() // 모든 요청에 대해 접근을 허용
                .and()
                .formLogin().disable() // 로그인 과정을 비활성화
                .httpBasic().disable(); // 기본 인증도 비활성화
    }
}
