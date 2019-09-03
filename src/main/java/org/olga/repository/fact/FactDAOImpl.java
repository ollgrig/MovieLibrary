package org.olga.repository.fact;

import org.olga.constant.fact.FactConstant;
import org.olga.entity.fact.Fact;
import org.olga.entity.fact.FactImpl;
import org.olga.repository.connection.DBConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FactDAOImpl implements FactDAO {
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

    private Fact getFromRS(ResultSet rs) {
        Fact fact = new FactImpl();
        try {
            fact.setId(rs.getLong(FactConstant.COLUMN_ID));
            fact.setFactText(rs.getString(FactConstant.COLUMN_FACT_TEXT));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return fact;
    }

    @Override
    public Fact getById(long id) {
        Fact fact = null;
        try (PreparedStatement statement = getConnection().prepareStatement(FactConstant.SELECT_FACT_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    fact = getFromRS(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return fact;
    }

    @Override
    public List<Fact> getAll() {
        List<Fact> factList = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(FactConstant.SELECT_ALL_FACT);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                factList.add(getFromRS(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return factList;
    }

    @Override
    public Fact create(Fact fact) {
        try (PreparedStatement statement = getConnection().prepareStatement(FactConstant.INSERT_FACT)) {
            statement.setLong(1, fact.getId());
            statement.setString(2, fact.getFactText());
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return getById(fact.getId());
    }

    @Override
    public Fact update(Fact fact) {
        try (PreparedStatement statement = getConnection().prepareStatement(FactConstant.UPDATE_FACT)) {
            statement.setString(1, fact.getFactText());
            statement.execute();
            return getById(fact.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(long id) {
        try (PreparedStatement statement = getConnection().prepareStatement(FactConstant.DELETE_FACT)) {
            statement.setLong(1, id);
            statement.execute();
            return (getById(id) == null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
