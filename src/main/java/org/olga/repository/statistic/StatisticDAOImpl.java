package org.olga.repository.statistic;

import org.olga.constant.statistic.StatisticConstant;
import org.olga.entity.statistic.Statistic;
import org.olga.entity.statistic.StatisticImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatisticDAOImpl implements StatisticDAO {

    private final Connection connection;

    public StatisticDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public Statistic getFromRS(ResultSet rs) {
        Statistic statistic = new StatisticImpl();
        try {
            statistic.setId(rs.getLong("id"));
            statistic.setBudget(rs.getDouble("budget"));
            statistic.setBoxOffice(rs.getDouble("box_office"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statistic;
    }
    @Override
    public Connection getConnection() {
        return null;
    }

   @Override
    public void getDefaultConnection() {

    }

    @Override
    public Statistic getById(long id) {
        Statistic statistic = null;
        try (PreparedStatement statement = this.connection.prepareStatement(StatisticConstant.SELECT_STATISTIC_BY_ID)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                statistic = getFromRS(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statistic;
    }

    @Override
    public List<Statistic> getAll() {
        List<Statistic> statisticList = new ArrayList<>();

        try {
            PreparedStatement statement = this.connection.prepareStatement(StatisticConstant.SELECT_ALL_STATISTIC);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                statisticList.add(getFromRS(rs));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statisticList;
    }

    @Override
    public Statistic create(Statistic statistic) {
        try (PreparedStatement statement = this.connection.prepareStatement(StatisticConstant.INSERT_STATISTIC)) {
            statement.setLong(1, statistic.getId());
            statement.setDouble(2, statistic.getBudget());
            statement.setDouble(3, statistic.getBoxOffice());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Statistic update(Statistic statistic) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
