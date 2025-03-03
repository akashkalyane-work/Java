package com.example.BookingApi.Dto;

import com.example.BookingApi.entity.Actor;
import com.example.BookingApi.entity.Director;
import com.example.BookingApi.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDto {

    private Integer movieId;
    private String movieName;
    private String grade;
    private Boolean isAdult;
    private String releaseYear;
    private GenreDto genre;
    private DirectorDto director;
    private ActorDto mainActorMale;
    private ActorDto mainActorFemale;

    public static MovieResponseDto mapToDto(Movie movie) {
        return new MovieResponseDto(
                movie.getMovieId(),
                movie.getMovieName(),
                movie.getGrade(),
                movie.getIsAdult(),
                movie.getReleaseYear(),
                GenreDto.mapToDto(movie.getGenre()),
                DirectorDto.mapToDto(movie.getDirector()),
                ActorDto.mapToDto(movie.getMainActorMale()),
                ActorDto.mapToDto(movie.getMainActorFemale())
        );
    }
}
