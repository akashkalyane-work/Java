package com.example.WithDatabase.repository;

import com.example.WithDatabase.entity.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserContactRepository extends JpaRepository<UserContact, Long> {
}
