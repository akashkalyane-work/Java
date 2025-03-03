package com.example.BookingApi.repository;

import com.example.BookingApi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByMovieName(String movieName);
}
