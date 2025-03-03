package com.example.BookingApi.repository;

import com.example.BookingApi.entity.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserContactRepository extends JpaRepository<UserContact, Integer> {
}
