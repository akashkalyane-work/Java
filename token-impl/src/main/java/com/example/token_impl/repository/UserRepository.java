package com.example.token_impl.repository;

import com.example.token_impl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);

    User findByEmail(String email);
}
