package com.example.WithDatabase.dto;

import com.example.WithDatabase.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private Long movieId;
    private String name;
    private String grade;
    private boolean isAdult;
    private Short releaseYear;

    public static MovieDto mapToDto(Movie movie){
        return new MovieDto(
                movie.getMovieId(),
                movie.getName(),
                movie.getGrade(),
                movie.isAdult(),
                movie.getReleaseYear()
        );
    }

}
