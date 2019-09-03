package org.olga.service.actor;

import org.olga.entity.actor.Actor;
import org.olga.repository.actor.ActorDAO;
import org.olga.repository.factory.DAOFactory;

import java.util.List;

public class ActorServiceImpl implements ActorService{
    private ActorDAO actorDAO = DAOFactory.getDAO(ActorDAO.class);
    @Override
    public Actor getActorById(long id) {
        return actorDAO.getById(id);
    }

    @Override
    public List<Actor> getAllActors() {
        return actorDAO.getAll();
    }

    @Override
    public Actor update(Actor actor) {
        Actor actorEntity = getActorById(actor.getId());
        if(actor.equals(actorEntity)){
            return actorEntity;
        }else {
            actorEntity.setName(actor.getName());
            actorEntity.setSurname(actor.getSurname());
            // end logic of converter
            return actorDAO.update(actorEntity);
        }
    }

    @Override
    public Actor create(Actor actor) {
        return actorDAO.create(actor);
    }

    @Override
    public void delete(long id) {
        System.out.println(actorDAO.delete(id)? "Deleted" : "Error");
    }
}
