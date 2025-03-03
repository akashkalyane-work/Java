package com.example.token_impl.controller;

import com.example.token_impl.service.UserService;
import com.example.token_impl.dto.LoginRequestDto;
import com.example.token_impl.dto.UserRequestDto;
import com.example.token_impl.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

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
    public ResponseEntity<?> validate(@RequestBody LoginRequestDto loginRequestDto){
        try {
            int result = userService.validate(loginRequestDto);
//            String result = userService.verify(loginRequestDto);
            return ResponseEntity.ok(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
