package org.olga.repository.statistic;

import org.olga.constant.statistic.StatisticConstant;
import org.olga.entity.statistic.Statistic;
import org.olga.entity.statistic.StatisticImpl;
import org.olga.repository.connection.DBConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatisticDAOImpl implements StatisticDAO {

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

    public Statistic getFromRS(ResultSet rs) {
        Statistic statistic = new StatisticImpl();
        try {
            statistic.setId(rs.getLong(StatisticConstant.COLUMN_ID));
            statistic.setBudget(rs.getDouble(StatisticConstant.COLUMN_BUDGET));
            statistic.setBoxOffice(rs.getDouble(StatisticConstant.COLUMN_BOX_OFFICE));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statistic;
    }

    @Override
    public Statistic getById(long id) {
        Statistic statistic = null;
        try (PreparedStatement statement = getConnection().prepareStatement(StatisticConstant.SELECT_STATISTIC_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    statistic = getFromRS(rs);
                }
            }
            return statistic;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Statistic> getAll() {
        List<Statistic> statisticList = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(StatisticConstant.SELECT_ALL_STATISTIC);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                statisticList.add(getFromRS(rs));
            }
            return statisticList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public Statistic create(Statistic statistic) {
        try (PreparedStatement statement = getConnection().prepareStatement(StatisticConstant.INSERT_STATISTIC)) {
            statement.setLong(1, statistic.getId());
            statement.setDouble(2, statistic.getBudget());
            statement.setDouble(3, statistic.getBoxOffice());
            statement.execute();
            return getById(statistic.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Statistic update(Statistic statistic) {
        try (PreparedStatement statement = getConnection().prepareStatement(StatisticConstant.UPDATE_STATISTIC)) {
            statement.setDouble(1, statistic.getBudget());
            statement.setDouble(2, statistic.getBoxOffice());
            statement.setLong(3, statistic.getId());
            statement.execute();
            return getById(statistic.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(long id) {
        try (PreparedStatement statement = getConnection().prepareStatement(StatisticConstant.DELETE_STATISTIC)) {
            statement.setLong(1, id);
            statement.execute();
            return (getById(id) == null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
