package com.example.WithDatabase.repository;

import com.example.WithDatabase.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}
