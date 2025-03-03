package com.example.StudentsToCourses.Controllers;

import com.example.StudentsToCourses.DTO.CoursesDto;
import com.example.StudentsToCourses.DTO.StudentsDto;
import com.example.StudentsToCourses.Entity.Students;
import com.example.StudentsToCourses.ErrorHandler.NotFoundException;
import com.example.StudentsToCourses.Service.StudentService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/csrf-token")
    public CsrfToken getcsrfToken(HttpServletRequest request){
        return (CsrfToken)  request.getAttribute("_csrf");
    }

    @GetMapping
    public List<StudentsDto> getallstudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getstudentsbyname(@PathVariable String name){
        try{
            List<StudentsDto> studentsDtos = studentService.getStudentsByName(name);
           return ResponseEntity.ok(studentsDtos);
        }
        catch (NotFoundException nf){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nf.getMessage());
        }
    }

    @GetMapping("/age/{age}")
    public List<StudentsDto> getstudentsbyname(@PathVariable Integer age){
        return studentService.getStudentsByAge(age);
    }

    @GetMapping("/email/{email}")
    public List<StudentsDto> getstudentsbyemail(@PathVariable String email){
        return studentService.getStudentsByEmail(email);
    }

    @GetMapping("coursecount/{num}")
    public ResponseEntity<?> findStudentsWithNumberOfCourses(@PathVariable Integer num){
        try {
            List<StudentsDto> studentsDto =  studentService.findStudentsWithNumberOfCourses(num);
            return ResponseEntity.ok(studentsDto);
        }catch (NotFoundException nf){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nf.getMessage());
        }
    }

    @PutMapping("/update-first-name")
    public ResponseEntity<String> updateFirstNameByEmail(
            @RequestParam String firstName,
            @RequestParam String email) {
        try {
            int rowsUpdated = studentService.updateFirstNameUsingEmail(firstName, email);
            return ResponseEntity.ok(rowsUpdated + " student(s) updated successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //http://localhost:8087/student/update-first-name?firstName=Emilyy&email=emily@gmail.com
    //http://localhost:8087/student/sort?page=0&size=5&sortBy=sid&sortOrder=desc

    @GetMapping("sort")
    public ResponseEntity<Page<StudentsDto>> paginationandsortby (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "sid") String  sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder
    ){
        Page<StudentsDto> studentsPage = studentService.getStudentsWithPaginationAndSorting(page,size,sortBy,sortOrder);
        return ResponseEntity.ok(studentsPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id){
        try{
            StudentsDto studentid = studentService.getStudentsById(id);
            return ResponseEntity.ok(studentid);
        }catch(NotFoundException nf){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nf.getMessage());
        }
    }

    @GetMapping("/courses")
    public List<CoursesDto> getallcourses(){
        return studentService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<?> getCoursesById(@PathVariable Long id){
       try {
           CoursesDto cid = studentService.getCourseById(id);
           return ResponseEntity.ok(cid);
       }catch (NotFoundException nf){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nf.getMessage());
       }
    }

    @PostMapping
    public Students createStudents(@Valid @RequestBody Students students){
        return studentService.createStudents(students);
    }

    @PutMapping("/{id}")
    public Students updateStudent(@PathVariable Long id,@RequestBody Students students){
        return studentService.updateStudents(id,students);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudents(id);
    }

}
