package com.example.BookingApi.service.impl;

import com.example.BookingApi.Dto.ActorDto;
import com.example.BookingApi.entity.Actor;
import com.example.BookingApi.repository.ActorRepository;
import com.example.BookingApi.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Override
    public List<ActorDto> getActors() {
        return actorRepository.findAll().stream()
                .map(ActorDto::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ActorDto getActorById(Integer id) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor Id not found"));
        return ActorDto.mapToDto(actor);
    }

    @Override
    public void addActor(ActorDto actorDto) {

    }

    @Override
    public void updateActor(Integer id, ActorDto actorDto) {

    }

    @Override
    public void deleteActor(Integer id) {

    }
}
