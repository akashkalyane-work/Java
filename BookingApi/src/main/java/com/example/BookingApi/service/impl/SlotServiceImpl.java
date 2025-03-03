package com.example.BookingApi.service.impl;

import com.example.BookingApi.Dto.SlotDto;
import com.example.BookingApi.entity.Slot;
import com.example.BookingApi.repository.SlotRepository;
import com.example.BookingApi.service.SlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SlotServiceImpl implements SlotService {

    private final SlotRepository slotRepository;

    @Override
    public List<SlotDto> getSlots() {
        return slotRepository.findAll().stream()
                .map(SlotDto::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SlotDto getSlotById(Integer id) {
        Slot slot = slotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Slot Id not found"));
        return SlotDto.mapToDto(slot);
    }

    @Override
    public void addSlot(SlotDto slotDto) {

    }

    @Override
    public void updateSlot(Integer id, SlotDto slotDto) {

    }

    @Override
    public void deleteSlot(Integer id) {

    }
}
