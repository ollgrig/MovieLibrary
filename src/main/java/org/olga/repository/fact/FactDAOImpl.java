package org.olga.repository.fact;

import org.olga.constant.fact.FactConstant;
import org.olga.entity.fact.Fact;
import org.olga.entity.fact.FactImpl;
import org.olga.repository.DataAccessObject;
import org.olga.repository.film.FilmDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FactDAOImpl implements FactDAO {
    private final Connection connection;

    public FactDAOImpl(Connection connection) {
        this.connection = connection;
    }


    public Fact getFromRS(ResultSet rs) {
        Fact fact = new FactImpl();
        try {
            fact.setId(rs.getLong("id"));
            fact.setFactText(rs.getString("fact_text"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fact;
    }

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public void getDefaultConnection() {

    }

    @Override
    public Fact getById(long id) {
        Fact fact = null;
        try (PreparedStatement statement = this.connection.prepareStatement(FactConstant.SELECT_FACT_BY_ID)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                fact = getFromRS(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fact;
    }

    @Override
    public List<Fact> getAll() {
        List<Fact> factList = new ArrayList<>();

        try {
            PreparedStatement statement = this.connection.prepareStatement(FactConstant.SELECT_ALL_FACT);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                factList.add(getFromRS(rs));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return factList;
    }

    @Override
    public Fact create(Fact fact) {
        try (PreparedStatement statement = this.connection.prepareStatement(FactConstant.INSERT_FACT)) {
            statement.setLong(1, fact.getId());
            statement.setString(2, fact.getFactText());
            //statement.setString(3, );
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Fact update(Fact fact) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
