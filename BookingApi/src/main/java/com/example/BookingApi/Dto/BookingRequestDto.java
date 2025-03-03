package com.example.BookingApi.Dto;

import com.example.BookingApi.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDto {
    private int movieId;
    private int theaterScreenId;
    private int price;
    private int slotId;
    private int numberOfSlot;
    private int createdBy;
}