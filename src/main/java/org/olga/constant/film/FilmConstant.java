package org.olga.constant.film;

public class FilmConstant {
    public static final String INSERT_FILM = "INSERT INTO film (id, name, statistic_id) VALUES (?, ?, ?)";
    public static final String SELECT_FILM_BY_ID = "SELECT id, name, statistic_id FROM film WHERE ID = ?";
    public static final String SELECT_ALL_FILM = "SELECT id, name, statistic_id FROM film";
    public static final String UPDATE_FILM = "UPDATE film SET name = ?, statistic_id = ? WHERE ID = ?";
    public static final String DELETE_FILM = "DELETE FROM film WHERE ID = ?";
}
