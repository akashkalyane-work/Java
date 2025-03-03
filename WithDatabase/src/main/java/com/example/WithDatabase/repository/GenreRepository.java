package com.example.WithDatabase.repository;

import com.example.WithDatabase.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
