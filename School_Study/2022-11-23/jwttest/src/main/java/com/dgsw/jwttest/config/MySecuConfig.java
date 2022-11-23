package com.dgsw.jwttest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class MySecuConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.formLogin();
        http.csrf().disable();
        http.logout();


        http.addFilterBefore(apiCheckFilter(), UsernamePasswordAuthenticationFilter.class);

        http.addFilterBefore(apiLoginFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public ApiCheckFilter apiCheckFilter(){
        return new ApiCheckFilter();
    }

    @Bean
    public ApiLoginFilter apiLoginFilter() throws Exception {
        ApiLoginFilter apiLoginFilter = new ApiLoginFilter("/api/login");
        apiLoginFilter.setAuthenticationManager(authenticationManager());
        return apiLoginFilter;
    }

}
