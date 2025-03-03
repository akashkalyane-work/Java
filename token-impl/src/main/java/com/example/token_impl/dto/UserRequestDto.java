package com.example.token_impl.dto;

import com.example.token_impl.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private String userName;
    private String email;
    private String password;

    public static UserRequestDto mapToDto(User user) {
        return new UserRequestDto(
                user.getUserName(),
                user.getEmail(),
                user.getPassword()
        );
    }

}
