package com.example.mybatis.Controller;

import com.example.mybatis.dto.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    // select 해서 테이블 내용 뿌려주는 거
    @GetMapping("findall")
    public String findall(Model model){
        System.out.println("findall");

        System.out.println(sqlSessionTemplate.selectList("test.findall"));
        List<Test> testlist = sqlSessionTemplate.selectList("test.findall");

        model.addAttribute("a", "10");
        model.addAttribute("testlist", testlist);

        return "findall";
    }

    // insert 해서 테이블에 행 삽입
    @GetMapping("insert")
    public String insert(Test test){
        return "insert";
    }

//    public String pinsert(@RequestParam String aa, @RequestParam String bb){
    @PostMapping("insert")
    public String pinsert(@Valid Test test, BindingResult bindingResult, Model model){
        System.out.println("일로오나");
//        System.out.println(aa);
//        System.out.println(bb);

        if (bindingResult.hasErrors()){
            System.out.println("에러 있음");
            model.addAttribute("error", true);
            return "insert";
        }

        System.out.println(test);
        System.out.println(test.getAa());
        System.out.println(test.getBb());

        sqlSessionTemplate.insert("test.inserttest", test);

        return "redirect:/board/findall";
    }

    @PostMapping("findall")
    public String delete(Long[] args) {

        for(Long arg:args) {
            sqlSessionTemplate.delete("deletetest", arg);
        }

        return "redirect:/board/findall";
    }

}
