package com.example.BookingApi.Dto;

import com.example.BookingApi.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponseDto {

    private Integer bookingId;
    private String movieName;
    private String theaterName;
    private String theaterScreenName;
    private Integer price;
    private String slotName;
    private Integer numberOfSlot;

    public static BookingResponseDto mapToDto(Booking booking) {
        return new BookingResponseDto(
                booking.getBookingId(),
                booking.getMovie().getMovieName(),
                booking.getTheaterScreen().getTheater().getTheaterName(),
                booking.getTheaterScreen().getScreenName(),
                booking.getPrice(),
                booking.getSlot().getSlotName(),
                booking.getNumberOfSlot()
        );
    }
}

