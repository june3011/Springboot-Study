package com.dgsw.ex01_springboot.config;

import com.dgsw.ex01_springboot.components.B;
import com.dgsw.ex01_springboot.components.C;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@Controller
public class MyConfig {

    // 객체를 넣기 위해서 하는 어노테이션
    @Bean
    public B b(){
        return new B();
    }

    @Bean
    public C c(){
        return new C();
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUsername("root");
        ds.setPassword("1234");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mariadb://localhost:3306/test_db");
        return ds;
    }

    @GetMapping("tablecreate")
    @ResponseBody
    public String tablecreate(){

        return "tablecreate";
    }

}
