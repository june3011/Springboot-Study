package com.dgsw.jwttest;

import com.dgsw.jwttest.config.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootTest
class JwttestApplicationTests {

	@Autowired
	JwtUtil jwtUtil;

	@Test
	void contextLoads() throws Exception {

		String jtoken = jwtUtil.generateToken("aa@naver.com");
		System.out.println(jtoken);

		String madeemail = jwtUtil.validateAndExtract(jtoken);
		System.out.println(madeemail);

	}

}
