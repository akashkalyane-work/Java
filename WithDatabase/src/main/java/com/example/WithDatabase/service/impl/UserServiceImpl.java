package com.example.WithDatabase.service.impl;

import com.example.WithDatabase.dto.UserDto;
import com.example.WithDatabase.entity.User;
import com.example.WithDatabase.exceptions.ResourceNotFoundException;
import com.example.WithDatabase.repository.UserRepository;
import com.example.WithDatabase.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserDto.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserDto.mapToDto(savedUser);
    }

    @Override
    public UserDto updateUser(long userId, UserDto userDto) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not exist with given id : " + userId)
        );

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        User updatedUser = userRepository.save(user);

        return UserDto.mapToDto(updatedUser);
    }

    @Override
    public void deleteUser(long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not exist with given id : " + userId)
        );

        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserDto.mapToDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not exist with given id : "+userId));
        return UserDto.mapToDto(user);
    }


}
