package com.example.BookingApi.Dto;

import com.example.BookingApi.entity.Slot;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SlotDto {

    private int slotId;
    private String slotName;

    public static SlotDto mapToDto(Slot slot){
        return new SlotDto(slot.getSlotId(), slot.getSlotName());
    }

}
