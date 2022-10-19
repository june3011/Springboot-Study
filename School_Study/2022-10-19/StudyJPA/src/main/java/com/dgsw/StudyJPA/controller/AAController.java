package com.dgsw.StudyJPA.controller;

import com.dgsw.StudyJPA.entity.AA;
import com.dgsw.StudyJPA.repository.AARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/aa")
public class AAController {

    @Autowired
    AARepository aaRepository;

    @GetMapping("save")
    public String save(){
        System.out.println("save");

        // insert 구문이 자동으로 만들어져서 실행됨
        aaRepository.save(new AA());
        return "save";
    }

    @GetMapping("savesetting")
    public String savesetting(){
        System.out.println("savesetting");
        // insert 구문이 자동으로 만들어져서 실행됨

//        AA aa = new AA();
//        aa.setAa("aa");
//        aa.setCdate(LocalDateTime.now());

        AA aa = AA.builder()
                .aa("aa")
                .bb("bb")
                .cdate(LocalDateTime.now())
                .mdate(LocalDateTime.now())
                .build();

        aaRepository.save(aa);

        return "save";
    }

    @GetMapping("all")
    public @ResponseBody List<AA> all(){
        return aaRepository.findAll();
    }

}
