package org.olga.repository.actor;

import org.olga.constant.actor.ActorConstant;
import org.olga.entity.actor.Actor;
import org.olga.entity.actor.ActorImpl;
import org.olga.repository.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorDAOImpl implements ActorDAO {
    private final Connection connection;

    public ActorDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public Actor getFromRS(ResultSet rs) {
        Actor actor = new ActorImpl();
        try {
            actor.setId(rs.getLong("id"));
            actor.setName(rs.getString("name"));
            actor.setSurname(rs.getString("surname"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actor;
    }

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public void getDefaultConnection() {

    }

    @Override
    public Actor getById(long id) {
        Actor actor = null;
        try (PreparedStatement statement = connection.prepareStatement(ActorConstant.SELECT_ACTOR_BY_ID)) {
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
            PreparedStatement statement = connection.prepareStatement(ActorConstant.SELECT_ALL_ACTOR);
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
        try (PreparedStatement statement = this.connection.prepareStatement(ActorConstant.INSERT_ACTOR)) {
            statement.setLong(1, actor.getId());
            statement.setString(2, actor.getName());
            statement.setString(3, actor.getSurname());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Actor update(Actor actor) {
        try (PreparedStatement statement = this.connection.prepareStatement(ActorConstant.UPDATE_ACTOR)) {
//            statement.setLong(1, actor.getId());
//            statement.setString(2, actor.getName());
//            statement.setString(3, actor.getSurname());
//            statement.setLong(3, actor.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
