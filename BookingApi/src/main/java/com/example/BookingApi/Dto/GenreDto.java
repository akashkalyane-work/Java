package com.example.BookingApi.Dto;

import com.example.BookingApi.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenreDto {

    private int genreId;
    private String genreName;

    public static GenreDto mapToDto(Genre genre){
        return new GenreDto(genre.getGenreId(), genre.getGenreName());
    }

}
