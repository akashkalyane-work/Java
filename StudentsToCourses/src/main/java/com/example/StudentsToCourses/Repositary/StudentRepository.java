package com.example.StudentsToCourses.Repositary;

import com.example.StudentsToCourses.DTO.StudentsDto;
import com.example.StudentsToCourses.Entity.Courses;
import com.example.StudentsToCourses.Entity.Students;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentRepository extends JpaRepository <Students,Long> {

    public List<Students> findByFirstNameContaining(String firstName);

    public List<Students> findStudentsByAge(Integer age);

    @Query("select s from Students s where s.email like :email%")
    public List<Students> findStudentsByEmailContains(String email);


    @Query(
            value = "SELECT s.* " +
                    "FROM jpa_students s " +
                    "WHERE s.sid IN (" +
                    "   SELECT sc.student_id " +
                    "   FROM jpa_courses sc " +
                    "   GROUP BY sc.student_id " +
                    "   HAVING COUNT(sc.cid) = :number" +
                    ")",
            nativeQuery = true
    )
    public List<Students> findStudentsWithNumberOfCourses(@Param("number") Integer number);


    @Modifying
    @Transactional
    @Query(
            value = "UPDATE jpa_students SET first_name = :first_Name WHERE email = :email_id",
            nativeQuery = true
    )
    public int updateFirstNameWithEmailId(@Param("first_Name") String firstName, @Param("email_id") String email);


    Page<Students> findAll(Pageable pageable);
}
