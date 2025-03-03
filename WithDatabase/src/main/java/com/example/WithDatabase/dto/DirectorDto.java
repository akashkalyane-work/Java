package com.example.WithDatabase.dto;

import com.example.WithDatabase.entity.Director;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDto {

    private Long directorId;
    private String Name;
    private Short Age;
    private String TypeOfMovies;

    public static DirectorDto mapToDto(Director director){
        return new DirectorDto(
                director.getDirectorId(),
                director.getName(),
                director.getAge(),
                director.getTypeOfMovies()
        );
    }

}
