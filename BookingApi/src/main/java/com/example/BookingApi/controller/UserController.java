package com.example.BookingApi.controller;

import com.example.BookingApi.Dto.LoginRequestDto;
import com.example.BookingApi.Dto.LoginResponseDto;
import com.example.BookingApi.Dto.UserRequestDto;
import com.example.BookingApi.Dto.UserResponseDto;
import com.example.BookingApi.entity.Booking;
import com.example.BookingApi.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        try{
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserRequestDto userRequestDto) {
        try{
            userService.addUser(userRequestDto);
            return ResponseEntity.ok("User added successfully");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody UserRequestDto userRequestDto) {
        try{
            userService.updateUser(id, userRequestDto);
            return ResponseEntity.ok("User updated successfully");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        try{
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> validate(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response){
        try {
//            int result = userService.validate(loginRequestDto);
            LoginResponseDto result = userService.verify(loginRequestDto);
            return ResponseEntity.ok(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<?> getBookingsByUserId(@PathVariable Integer id){
        try {
            List<?> result = userService.getBookingByUserId(id);
            return ResponseEntity.ok(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

