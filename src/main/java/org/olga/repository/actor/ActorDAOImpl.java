package org.olga.repository.actor;

import org.olga.constant.actor.ActorConstant;
import org.olga.constant.film.FilmConstant;
import org.olga.entity.actor.Actor;
import org.olga.entity.actor.ActorImpl;
import org.olga.repository.connection.DBConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorDAOImpl implements ActorDAO {
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


    private Actor getFromRS(ResultSet rs) {
        Actor actor = new ActorImpl();
        try {
            actor.setId(rs.getLong(ActorConstant.COLUMN_ID));
            actor.setName(rs.getString(ActorConstant.COLUMN_NAME));
            actor.setSurname(rs.getString(ActorConstant.COLUMN_SURNAME));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return actor;
    }


    @Override
    public Actor getById(long id) {
        Actor actor = null;
        try (PreparedStatement statement = getConnection().prepareStatement(ActorConstant.SELECT_ACTOR_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    actor = getFromRS(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return actor;
    }

    @Override
    public List<Actor> getAll() {
        List<Actor> actorList = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement(ActorConstant.SELECT_ALL_ACTOR);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                actorList.add(getFromRS(rs));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actorList;
    }

    @Override
    public Actor create(Actor actor) {
        try (PreparedStatement statement = getConnection().prepareStatement(ActorConstant.INSERT_ACTOR)) {
            statement.setLong(1, actor.getId());
            statement.setString(2, actor.getName());
            statement.setString(3, actor.getSurname());
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return getById(actor.getId());
    }

    @Override
    public Actor update(Actor actor) {
        try (PreparedStatement statement = getConnection().prepareStatement(ActorConstant.UPDATE_ACTOR)) {
            statement.setString(1, actor.getName());
            statement.setString(2, actor.getSurname());
            statement.setLong(3, actor.getId());
            statement.execute();
            return getById(actor.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(long id) {
        try (PreparedStatement statement = getConnection().prepareStatement(ActorConstant.DELETE_ACTOR)) {
            statement.setLong(3, id);
            statement.execute();
            return (getById(id) == null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
