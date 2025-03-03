package com.example.WithDatabase.repository;

import com.example.WithDatabase.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
