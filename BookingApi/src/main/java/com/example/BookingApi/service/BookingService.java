package com.example.BookingApi.service;

import com.example.BookingApi.Dto.BookingRequestDto;
import com.example.BookingApi.Dto.BookingResponseDto;
import com.example.BookingApi.Dto.DirectorDto;

import java.util.List;

public interface BookingService {
    List<BookingResponseDto> getBookings();
    BookingResponseDto getBookingById(Integer id);
    void addBooking(BookingRequestDto bookingRequestDto);
    void updateBooking(Integer id, BookingRequestDto bookingRequestDto);
    void deleteBooking(Integer id);

    interface DirectorService {
        List<DirectorDto> getDirectors();
        DirectorDto getDirectorById(Integer id);
        void addDirector(DirectorDto directorDto);
        void updateDirector(Integer id, DirectorDto directorDto);
        void deleteDirector(Integer id);
    }
}