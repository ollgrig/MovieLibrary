package org.olga.constant.actor;

public class ActorConstant {
    public static final String INSERT_ACTOR = "INSERT INTO actor (id, name, surname) VALUES (?, ?, ?)";
    public static final String SELECT_ACTOR_BY_ID = "SELECT id, name, surname FROM actor WHERE ID = ?";
    public static final String SELECT_ALL_ACTOR = "SELECT id, name, surname FROM actor";
    public static final String UPDATE_ACTOR = "UPDATE actor SET name = ?, surname = ? WHERE ID = ?";
    public static final String DELETE_ACTOR = "DELETE FROM actor WHERE ID = ?";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME = "surname";

    private ActorConstant() {
        throw new IllegalArgumentException("Should not be instantiated");
    }
}
