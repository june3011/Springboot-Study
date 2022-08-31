package com.dgsw.ex01_springboot.controller;

import com.dgsw.ex01_springboot.components.A;
import com.dgsw.ex01_springboot.components.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class AController {

    @Autowired
    A a1;

    @Autowired
    A a2;

    // Autowired 를 쓰게 되면 spring 객체 담는 컨테이너에 있는 A를 가져옴


    @Autowired
    DataSource ds;

    @Autowired
    C c;

    @GetMapping("aa")
    public String aa(){
        A a3 = new A();
        // a3를 새로운 메모리상에서 새로 만듦

        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a3 = " + a3);

        return "aa";
    }

    @GetMapping("tablecreate")
    @ResponseBody
    public String tablecreate() {
        Connection connection = null;
        try {
            connection = ds.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "create table test ( aa varchar(20), bb varchar(20) )");
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        return "tablecreate";
    }

}
