package com.example.jun_board.controller;

import com.example.jun_board.config.JwtUtil;
import com.example.jun_board.dto.LogInDTO;
import com.example.jun_board.dto.SignUpDTO;
import com.example.jun_board.entity.User;
import com.example.jun_board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public void signup(
            @RequestBody SignUpDTO dto
    ){
        System.out.println("signup");

        List<User> userList = userRepository.findAll();
        System.out.println(userList);

        for (User trySignupUser : userList){
            if (dto.getName().equals(trySignupUser.getUsername())){
                System.out.println("겹침");
                throw new RuntimeException("동일한 이름을 가진 사용자가 있습니다");
            }
        }

        User user = User.builder()
                .username(dto.getName())
                .password(passwordEncoder.encode(dto.getPw())).build();

        System.out.println(user.getUserId()+" "+user.getUsername()+" "+user.getPassword());
        System.out.println(user.getUsername()+" 님 회원가입 완료");

        userRepository.save(user);
    }

    @PostMapping("login")
    public String login(@RequestBody LogInDTO dto){
        String name = dto.getName(), pw = dto.getPw();
        Optional<User> correctUser = userRepository.findByUsername(name);

        // 레포지토리에서 찾기 id같은 거 찾기 그리고 pw 비교
        if(passwordEncoder.matches(pw, correctUser.get().getPassword())) {
            String token = jwtUtil.generateToken(name);
            System.out.println("login 성공");
            return token;
        } else {
            throw new RuntimeException("비밀번호가 잘못되었습니다");
        }
    }

    @GetMapping("myInfo")
    public String myInfo(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return user.getUsername();
    }

}
