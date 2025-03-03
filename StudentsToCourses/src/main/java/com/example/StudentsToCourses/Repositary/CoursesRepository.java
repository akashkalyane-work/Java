package com.example.StudentsToCourses.Repositary;

import com.example.StudentsToCourses.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository <Courses,Long> {
}
