package com.example.jun_board.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class ApiCheckFilter extends OncePerRequestFilter {  // 요청되는 모든 주소에 대해서 필터를 걸어준다.

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("apicheckfilter");

        String auth = request.getHeader("Authorization");

        // jwt 가지고 있는 지 확인
        if (request.getRequestURI().equals("/user/login")){
            filterChain.doFilter(request, response);
        } else if(request.getRequestURI().equals("/user/signup")) {
            filterChain.doFilter(request,response);
        } else if (request.getRequestURI().equals("/board/list")){
            filterChain.doFilter(request, response);
        } else if (auth != null && auth.startsWith("Bearer ")){
            String[] token = auth.split("Bearer ");
            try {
                System.out.println(auth.substring(7));
                String email = jwtUtil.validateAndExtract(auth.substring(7));
                System.out.println("email = " + email);
            } catch (Exception e) {
                System.out.println("일로오나");
                e.printStackTrace();
            }

            SecurityContextHolder.getContext().setAuthentication(jwtUtil.getAuthentication(token[1]));
            filterChain.doFilter(request, response);
        }
    }
}
