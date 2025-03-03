package com.example.WithDatabase.dto;

import com.example.WithDatabase.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private Long bookingId;
    private Short price;
    private Short noOfSlots;
    private Long movieId;

    public static BookingDto mapToDto(Booking booking){
        return new BookingDto(
                booking.getBookingId(),
                booking.getPrice(),
                booking.getNoOfSlots(),
                booking.getMovie().getMovieId()
        );
    }

}
