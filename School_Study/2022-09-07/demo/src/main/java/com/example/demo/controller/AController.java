package com.example.demo.controller;

import com.example.demo.components.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class AController {

    @Autowired
    A a;


    @GetMapping("aa")
    public String aa(Model model){
        a.doA();

        // thymeleaf 문법 이용

        // html파일에서 insert replace include 많이 사용

        model.addAttribute("aa", "a문자열");
        model.addAttribute("mya", "2");

        List<String> alist = Arrays.asList("홍길동","김길동","이길동");
        model.addAttribute("alist", alist);

        model.addAttribute("mytrue", true);
        model.addAttribute("myfalse", false);

        return "aa";
    }

}
