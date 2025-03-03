package com.example.StudentsToCourses.DTO;

import com.example.StudentsToCourses.Entity.Courses;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;

@Data
//@JsonIgnoreProperties("studentsDto")
@Embeddable
public class CoursesDto {
    private Long cid;
    private String name;
    private String duration;


    //private StudentsDto studentsDto;

    public static CoursesDto CourseToDto(Courses courses) {
        CoursesDto coursesDto = new CoursesDto();
        coursesDto.setCid(courses.getCid());
        coursesDto.setName(courses.getName());
        coursesDto.setDuration(courses.getDuration());
//        if (courses.getStudents() != null) {
//            StudentsDto studentsDto = new StudentsDto();
//            studentsDto.setSid(courses.getStudents().getSid());
//            studentsDto.setFirstName(courses.getStudents().getFirstName());
//            studentsDto.setLastName(courses.getStudents().getLastName());
//            studentsDto.setAge(courses.getStudents().getAge());
//            coursesDto.setStudentsDto(studentsDto);
//        }
        return coursesDto;
    }
}



