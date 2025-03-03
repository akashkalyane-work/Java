package com.example.WithDatabase.repository;

import com.example.WithDatabase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
