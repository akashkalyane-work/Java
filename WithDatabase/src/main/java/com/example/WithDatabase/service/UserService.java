package com.example.WithDatabase.service;

import com.example.WithDatabase.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getUsers();

    UserDto getUserById(long userId);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(long userId, UserDto userDto);

    void deleteUser(long userId);

}
