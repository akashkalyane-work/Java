package com.example.BookingApi.service.impl;

import com.example.BookingApi.Dto.GenreDto;
import com.example.BookingApi.entity.Genre;
import com.example.BookingApi.repository.GenreRepository;
import com.example.BookingApi.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public List<GenreDto> getGenres() {
        return genreRepository.findAll().stream()
                .map(GenreDto::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public GenreDto getGenreById(Integer id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor Id not found"));
        return GenreDto.mapToDto(genre);
    }

    @Override
    public void addGenre(GenreDto genreDto) {

    }

    @Override
    public void updateGenre(Integer id, GenreDto genreDto) {

    }

    @Override
    public void deleteGenre(Integer id) {

    }
}
