package com.example.jun_board.config;

import com.example.jun_board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyDetailService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUserName = " + username);

        Optional<com.example.jun_board.entity.User> user = userRepository.findByUsername(username);

        System.out.println(user);
        return User.builder()
                .username(user.get().getUsername())
                .password(user.get().getPassword())
                .roles("USER")
                .build();
    }

}
