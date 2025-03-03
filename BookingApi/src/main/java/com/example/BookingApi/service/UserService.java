package com.example.BookingApi.service;

import com.example.BookingApi.Dto.*;
import com.example.BookingApi.entity.Booking;

import java.util.List;

public interface UserService {

    List<UserResponseDto> getUsers();
    UserResponseDto getUserById(Integer id);
    void addUser(UserRequestDto userRequestDto);
    void updateUser(Integer id, UserRequestDto userRequestDto);
    void deleteUser(Integer id);
    int validate(LoginRequestDto loginRequestDto);
    LoginResponseDto verify(LoginRequestDto loginRequestDto);

    List<BookingResponseDto> getBookingByUserId(Integer id);

}
