package org.olga.entity.actor;

import org.olga.entity.Entity;

public interface Actor extends Entity {
    String getName();

    void setName(String name);

    String getSurname();

    void setSurname(String surname);
}
