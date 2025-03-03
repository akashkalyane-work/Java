package com.example.BookingApi.service.impl;

import com.example.BookingApi.Dto.TheaterDto;
import com.example.BookingApi.entity.Theater;
import com.example.BookingApi.repository.TheaterRepository;
import com.example.BookingApi.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;


    @Override
    public List<TheaterDto> getTheaters() {
        return theaterRepository.findAll().stream()
                .map(TheaterDto::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TheaterDto getTheaterById(Integer id) {
        Theater theater = theaterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor Id not found"));
        return TheaterDto.mapToDto(theater);
    }

    @Override
    public void addTheater(TheaterDto theaterDto) {

    }

    @Override
    public void updateTheater(Integer id, TheaterDto theaterDto) {

    }

    @Override
    public void deleteTheater(Integer id) {

    }
}
