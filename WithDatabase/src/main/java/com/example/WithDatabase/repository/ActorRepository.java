package com.example.WithDatabase.repository;

import com.example.WithDatabase.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
