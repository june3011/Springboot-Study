package com.example.jun_board.repository;

import com.example.jun_board.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    // select * from user where name = username
    Optional<User> findByUsername(String username);
}
