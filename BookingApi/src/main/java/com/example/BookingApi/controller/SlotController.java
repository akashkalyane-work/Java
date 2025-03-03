package com.example.BookingApi.controller;

import com.example.BookingApi.Dto.SlotDto;
import com.example.BookingApi.service.SlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/slots")
@RequiredArgsConstructor
public class SlotController {
    private final SlotService slotService;

    @GetMapping
    public List<SlotDto> getSlots() {
        return slotService.getSlots();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSlotById(@PathVariable Integer id) {
        try{
            return ResponseEntity.ok(slotService.getSlotById(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> addSlot(@RequestBody SlotDto slotDto) {
        try{
            slotService.addSlot(slotDto);
            return ResponseEntity.ok("Slot added successfully");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateSlot(@PathVariable Integer id, @RequestBody SlotDto slotDto) {
        try{
            slotService.updateSlot(id, slotDto);
            return ResponseEntity.ok("Slot updated successfully");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSlot(@PathVariable Integer id) {
        try{
            slotService.deleteSlot(id);
            return ResponseEntity.ok("Slot deleted successfully");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
