package com.example.BookingApi.service;

import com.example.BookingApi.Dto.GenreDto;

import java.util.List;

public interface GenreService {
    List<GenreDto> getGenres();
    GenreDto getGenreById(Integer id);
    void addGenre(GenreDto genreDto);
    void updateGenre(Integer id, GenreDto genreDto);
    void deleteGenre(Integer id);
}
