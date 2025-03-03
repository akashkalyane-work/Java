package com.example.WithDatabase.dto;

import com.example.WithDatabase.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userId;
    private String username;
    private String email;
    private String password;

    public static UserDto mapToDto(User user) {
        return new UserDto(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getUserId(),
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }
}
