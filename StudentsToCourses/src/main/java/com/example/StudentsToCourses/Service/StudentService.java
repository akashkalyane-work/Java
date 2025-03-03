package com.example.StudentsToCourses.Service;

import com.example.StudentsToCourses.DTO.CoursesDto;
import com.example.StudentsToCourses.DTO.StudentsDto;
import com.example.StudentsToCourses.Entity.Courses;
import com.example.StudentsToCourses.Entity.Students;
import com.example.StudentsToCourses.ErrorHandler.NotFoundException;
import com.example.StudentsToCourses.Repositary.CoursesRepository;
import com.example.StudentsToCourses.Repositary.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CoursesRepository coursesRepository;


    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);



//    private CoursesDto CourseEntityToDto(Courses courses) {
//        CoursesDto coursesDto = new CoursesDto();
//        coursesDto.setCid(courses.getCid());
//        coursesDto.setName(courses.getName());
//        coursesDto.setDuration(courses.getDuration());
//        if (courses.getStudents() != null) {
//            StudentsDto studentsDto = new StudentsDto();
//            studentsDto.setSid(courses.getStudents().getSid());
//            studentsDto.setFirstName(courses.getStudents().getFirstName());
//            studentsDto.setLastName(courses.getStudents().getLastName());
//            studentsDto.setAge(courses.getStudents().getAge());
//            coursesDto.setStudentsDto(studentsDto);
//        }
//        return coursesDto;
//    }


//    private StudentsDto StudentEntityToDto(Students students){
//        StudentsDto studentsDto = new StudentsDto();
//        studentsDto.setSid(students.getSid());
//        studentsDto.setAge(students.getAge());
//        studentsDto.setFirstName(students.getFirstName());
//        studentsDto.setLastName(students.getLastName());
//        List<CoursesDto> coursesDtoList = students.getCourses()
//                .stream()
//                .map(this::CourseEntityToDto)
//                .collect(Collectors.toList());
//        studentsDto.setCoursesDto(coursesDtoList);
//        return studentsDto;
//    }



//    public List<CoursesDto> getAllCourses(){
//        return coursesRepository.findAll()
//                .stream()
//                .map(this::CourseEntityToDto)
//                .collect(Collectors.toList());
//    }
//
//    public List<StudentsDto> getAllStudents(){
//        return studentRepository.findAll()
//                .stream()
//                .map(this::StudentEntityToDto)
//                .collect(Collectors.toList());
//    }



    public List<CoursesDto> getAllCourses(){
        return coursesRepository.findAll()
                .stream()
                .map(CoursesDto :: CourseToDto )
                .collect(Collectors.toList());
    }

    public CoursesDto getCourseById(Long cid) {
        Courses courses = coursesRepository.findById(cid)
                .orElseThrow(() -> new NotFoundException("Course with ID " + cid + " not found"));
        return CoursesDto.CourseToDto(courses);
    }

    public StudentsDto getStudentsById(Long sid){
        Students students = studentRepository.findById(sid)
                .orElseThrow(()-> new NotFoundException("Student with ID " + sid + " not found"));
        return StudentsDto.StudentToDto(students);
    }


    public List<StudentsDto> getAllStudents(){
        return studentRepository.findAll()
                .stream()
                .map( StudentsDto :: StudentToDto)
                .collect(Collectors.toList());
    }

    public List<StudentsDto> getStudentsByName(String name){
        List<Students> students =  studentRepository.findByFirstNameContaining(name);
        if (students.isEmpty()){
            throw new NotFoundException("Student "+name+" not found");
        }
        else {
            return students.stream()
                    .map(StudentsDto :: StudentToDto)
                    .collect(Collectors.toList());
        }
    }

    public List<StudentsDto> getStudentsByAge(Integer age){
        List<Students> students =  studentRepository.findStudentsByAge(age);
        return students.stream()
                .map(StudentsDto :: StudentToDto)
                .collect(Collectors.toList());
    }

    public List<StudentsDto> getStudentsByEmail(String email){
        List<Students> students = studentRepository.findStudentsByEmailContains(email);
        return students.stream()
                .map(StudentsDto :: StudentToDto)
                .collect(Collectors.toList());
    }

    public List<StudentsDto> findStudentsWithNumberOfCourses(Integer num){
        List<Students> students = studentRepository.findStudentsWithNumberOfCourses(num);
        if (students.isEmpty()){
            throw new NotFoundException("Student with "+num+" courses not found");
        }
        else {
            return students.stream()
                    .map(StudentsDto :: StudentToDto)
                    .collect(Collectors.toList());
        }
    }

    public int updateFirstNameUsingEmail(String firstName, String email){
        int stud = studentRepository.updateFirstNameWithEmailId(firstName,email);
        if (stud == 0){
            throw new RuntimeException("no student with this email "+email+" found");
        }
        return stud;
    }

    public Page<StudentsDto> getStudentsWithPaginationAndSorting(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = Sort.Direction.ASC;
        if ("desc".equalsIgnoreCase(sortOrder)) {
            direction = Sort.Direction.DESC;
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        Page<Students> studentsPage = studentRepository.findAll(pageable);
        return studentsPage.map(StudentsDto::StudentToDto); //preserves pagination metadata
    }


    public Students createStudents(Students students){
        if(students.getCourses().isEmpty()){
            throw new IllegalArgumentException("Courses are not added");
        }else{
            students.setPassword(passwordEncoder.encode(students.getPassword()));
            for (Courses courses : students.getCourses()){
                courses.setStudents(students);
            }
            return studentRepository.save(students);
        }
    }

    public Students updateStudents(Long id ,Students students){
        Optional<Students> sid = studentRepository.findById(id);
        if(sid.isPresent()){
            students.setPassword(passwordEncoder.encode(students.getPassword()));
            for (Courses courses : students.getCourses()){
                courses.setStudents(students);
            }
            return studentRepository.save(students);
        }
        else {
            throw new RuntimeException("Student with id "+id+" not found");
        }
    }

    public String deleteStudents(Long id){
        Optional<Students> sid = studentRepository.findById(id);
        if (sid.isPresent()){
            studentRepository.deleteById(id);
            return "Student with id "+id+" is deleted";
        }else {
            throw new RuntimeException("Student with id "+id+" not found");
        }
    }


}
