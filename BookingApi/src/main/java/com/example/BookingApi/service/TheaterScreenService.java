package com.example.BookingApi.service;

import com.example.BookingApi.Dto.TheaterScreenDto;

import java.util.List;

public interface TheaterScreenService {
    List<TheaterScreenDto> getTheaterScreens();
    TheaterScreenDto getTheaterScreenById(Integer id);
    void addTheaterScreen(TheaterScreenDto theaterScreenDto);
    void updateTheaterScreen(Integer id, TheaterScreenDto theaterScreenDto);
    void deleteTheaterScreen(Integer id);
}
