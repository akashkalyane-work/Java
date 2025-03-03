package com.example.BookingApi.service;

import com.example.BookingApi.Dto.TheaterDto;

import java.util.List;

public interface TheaterService {
    List<TheaterDto> getTheaters();
    TheaterDto getTheaterById(Integer id);
    void addTheater(TheaterDto theaterDto);
    void updateTheater(Integer id, TheaterDto theaterDto);
    void deleteTheater(Integer id);
}
