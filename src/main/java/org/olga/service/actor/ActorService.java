package org.olga.service.actor;

import org.olga.entity.actor.Actor;
import org.olga.repository.DataAccessObject;

import java.util.List;

public interface ActorService {
    Actor getActorById(long id);

    List<Actor> getAllActors();

    Actor update(Actor actor);

    Actor create(Actor actor);

    void delete(long id);
}
