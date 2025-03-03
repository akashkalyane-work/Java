package com.example.BookingApi.service.impl;

import com.example.BookingApi.Dto.TheaterScreenDto;
import com.example.BookingApi.entity.TheaterScreen;
import com.example.BookingApi.repository.TheaterScreenRepository;
import com.example.BookingApi.service.TheaterScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TheaterScreenServiceImpl implements TheaterScreenService {

    private final TheaterScreenRepository theaterScreenRepository;

    @Override
    public List<TheaterScreenDto> getTheaterScreens() {
        return theaterScreenRepository.findAll().stream()
                .map(TheaterScreenDto::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TheaterScreenDto getTheaterScreenById(Integer id) {
        TheaterScreen theaterScreen = theaterScreenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor Id not found"));
        return TheaterScreenDto.mapToDto(theaterScreen);
    }

    @Override
    public void addTheaterScreen(TheaterScreenDto theaterScreenDto) {

    }

    @Override
    public void updateTheaterScreen(Integer id, TheaterScreenDto theaterScreenDto) {

    }

    @Override
    public void deleteTheaterScreen(Integer id) {

    }
}
