package com.dip.dip.controller;

import com.dip.dip.entity.Member;
import com.dip.dip.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("members")
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("login")
    public String lgoin(){
        return "members/login";
    }

    @GetMapping("signup")
    public String signin(){
        return "members/signup";
    }

    @PostMapping("signup")
    public String psignup(Member member){
        System.out.println("일로오나");
        System.out.println(member);

        member.setPassword(passwordEncoder.encode(member.getPassword()));

        // insert into member values (email, password);
        memberRepository.save(member);

        return "redirect:/members/login";
    }

}
