package com.example.WithDatabase.dto;

import com.example.WithDatabase.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto {
    private Long genreId;
    private String name;

    public static GenreDto mapToDto(Genre genre){
        return new GenreDto(genre.getGenreId(), genre.getName());
    }
}
