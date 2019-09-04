package org.olga.service.actor;

import org.olga.entity.actor.Actor;
import org.olga.repository.actor.ActorDAO;
import org.olga.repository.factory.DAOFactory;

import java.util.List;

import static java.util.Objects.isNull;

public class ActorServiceImpl implements ActorService {
    private ActorDAO actorDAO;

    ActorDAO getActorDAO() {
        if (isNull(actorDAO)) {
            actorDAO = DAOFactory.getDAO(ActorDAO.class);
        }
        return actorDAO;
    }

    @Override
    public Actor getActorById(long id) {
        return getActorDAO().getById(id);
    }

    @Override
    public List<Actor> getAllActors() {
        return getActorDAO().getAll();
    }

    @Override
    public Actor update(Actor actor) {
        Actor actorEntity = getActorById(actor.getId());
        if (actor.equals(actorEntity)) {
            return actorEntity;
        } else {
            return getActorDAO().update(converter(actor, actorEntity));
        }
    }

    Actor converter(Actor actor, Actor actorEntity) {
        actorEntity.setName(actor.getName());
        actorEntity.setSurname(actor.getSurname());
        return actorEntity;
    }

    @Override
    public Actor create(Actor actor) {
        return getActorDAO().create(actor);
    }

    @Override
    public void delete(long id) {
        System.out.println(getActorDAO().delete(id) ? "Deleted" : "Error");
    }
}
