package com.example.WithDatabase.repository;

import com.example.WithDatabase.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<Slot, Long> {
}
