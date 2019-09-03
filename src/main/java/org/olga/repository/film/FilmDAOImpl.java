package org.olga.repository.film;

import org.olga.constant.film.FilmConstant;
import org.olga.entity.film.Film;
import org.olga.entity.film.FilmImpl;
import org.olga.repository.connection.DBConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmDAOImpl implements FilmDAO {
    private Connection connection;

    @Override
    public synchronized Connection getConnection() {
        if (connection == null) {
            connection = getDefaultConnection();
        }
        return connection;
    }

    @Override
    public synchronized Connection getDefaultConnection() {
        try {
            return new DBConnectionManager().getConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Film getFromRS(ResultSet rs) {
        Film film = new FilmImpl();
        try {
            film.setId(rs.getLong(FilmConstant.COLUMN_ID));
            film.setName(rs.getString(FilmConstant.COLUMN_NAME));
            film.setStatisticId(rs.getLong(FilmConstant.COLUMN_STATISTIC_ID));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return film;
    }

    @Override
    public Film getById(long id) {
        Film film = null;
        try (PreparedStatement statement = getConnection().prepareStatement(FilmConstant.SELECT_FILM_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    film = getFromRS(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return film;
    }

    @Override
    public List<Film> getAll() {
        List<Film> filmList = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(FilmConstant.SELECT_ALL_FILM);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                filmList.add(getFromRS(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return filmList;
    }

    @Override
    public Film create(Film film) {
        try (PreparedStatement statement = getConnection().prepareStatement(FilmConstant.INSERT_FILM)) {
            statement.setLong(1, film.getId());
            statement.setString(2, film.getName());
            statement.setLong(3, film.getStatisticId());
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return getById(film.getId());
    }

    @Override
    public Film update(Film film) {
        try (PreparedStatement statement = getConnection().prepareStatement(FilmConstant.UPDATE_FILM)) {
            statement.setString(1, film.getName());
            statement.setLong(2, film.getStatisticId());
            statement.setLong(3, film.getId());
            statement.execute();
            return getById(film.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public boolean delete(long id) {
        try (PreparedStatement statement = getConnection().prepareStatement(FilmConstant.DELETE_FILM)) {
            statement.setLong(1, id);
            statement.execute();
            return (getById(id) == null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
