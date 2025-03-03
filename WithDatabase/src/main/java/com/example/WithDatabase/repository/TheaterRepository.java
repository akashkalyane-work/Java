package com.example.WithDatabase.repository;

import com.example.WithDatabase.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
