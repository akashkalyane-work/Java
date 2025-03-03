package com.example.StudentsToCourses.DTO;

import com.example.StudentsToCourses.Entity.Courses;
import com.example.StudentsToCourses.Entity.Students;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Data
public class StudentsDto {
    private Long sid;
    private String firstName;
    private String lastName;
    private Integer age;


    @JsonProperty("courses")
    @Embedded
    private List<CoursesDto> coursesDto = new ArrayList<>();


    public static StudentsDto StudentToDto(Students students){
        StudentsDto studentsDto = new StudentsDto();
        studentsDto.setSid(students.getSid());
        studentsDto.setAge(students.getAge());
        studentsDto.setFirstName(students.getFirstName());
        studentsDto.setLastName(students.getLastName());
        List<CoursesDto> coursesDtoList = students.getCourses()
                .stream()
                .map(CoursesDto::CourseToDto)
                .collect(Collectors.toList());
        studentsDto.setCoursesDto(coursesDtoList);
        return studentsDto;
    }


}
