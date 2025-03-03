package com.example.BookingApi.service;

import com.example.BookingApi.Dto.SlotDto;

import java.util.List;

public interface SlotService {

    List<SlotDto> getSlots();
    SlotDto getSlotById(Integer id);
    void addSlot(SlotDto slotDto);
    void updateSlot(Integer id, SlotDto slotDto);
    void deleteSlot(Integer id);

}
