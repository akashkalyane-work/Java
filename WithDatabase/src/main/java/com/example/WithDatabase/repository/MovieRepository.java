package com.example.WithDatabase.repository;

import com.example.WithDatabase.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
