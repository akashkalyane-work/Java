package com.example.WithDatabase.dto;

import com.example.WithDatabase.entity.Slot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlotDto {

    private Long slotId;
    private String name;
    private boolean isAvailable;

    public static SlotDto mapToDto(Slot slot){
        return new SlotDto(slot.getSlotId(), slot.getName(), slot.getIsAvailable());
    }

}
