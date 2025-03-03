package com.example.BookingApi.service;

import com.example.BookingApi.Dto.MovieRequestDto;
import com.example.BookingApi.Dto.MovieResponseDto;

import java.util.List;

public interface MovieService {
    List<MovieResponseDto> getMovies();
    MovieResponseDto getMovieById(Integer id);
    void addMovie(MovieRequestDto movieRequestDto);
    void updateMovie(Integer id, MovieRequestDto movieRequestDto);
    void deleteMovie(Integer id);
}
