package com.example.WithDatabase.dto;

import com.example.WithDatabase.entity.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorDto {
    private Long actorId;
    private String name;
    private Short age;
    private boolean hasAward;
    private Short NoOfMoviesWorkedOn;

    public static ActorDto mapToDto(Actor actor){
        return new ActorDto(
                actor.getActorId(), actor.getName(), actor.getAge(),
                actor.isHasAward(), actor.getNoOfMoviesWorkedOn());
    }

}
