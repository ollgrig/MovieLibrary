package org.olga.entity.actor;

import org.olga.entity.EntityImpl;

public class ActorImpl extends EntityImpl implements Actor {
    private long id;
    private String name;
    private String surname;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
