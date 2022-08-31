package com.dgsw.ex01_springboot.controller;

import com.dgsw.ex01_springboot.components.A;
import com.dgsw.ex01_springboot.components.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 스프링 객체 담는 통 안에 넣기 위해서
@Controller
public class BController {

    @Autowired A a;

    @Autowired B b;


    @GetMapping("bb")
    public String bb(){
        a.doA();
        b.doB();
        return "bb";
    }

}
