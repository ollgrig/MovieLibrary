package org.olga.service.statistic;

import org.olga.entity.statistic.Statistic;
import org.olga.repository.factory.DAOFactory;
import org.olga.repository.statistic.StatisticDAO;

import java.util.List;

import static java.util.Objects.isNull;

public class StatisticServiceImpl implements StatisticService {
    private StatisticDAO statisticDAO;

    StatisticDAO getStatisticDAO() {
        if (isNull(statisticDAO)) {
            statisticDAO = DAOFactory.getDAO(StatisticDAO.class);
        }
        return statisticDAO;
    }

    @Override
    public Statistic getStatisticById(long id) {
        return getStatisticDAO().getById(id);
    }

    @Override
    public List<Statistic> getAllStatistics() {
        return getStatisticDAO().getAll();
    }

    @Override
    public Statistic update(Statistic statistic) {
        Statistic statisticEntity = getStatisticById(statistic.getId());
        if (statistic.equals(statisticEntity)) {
            return statisticEntity;
        } else {
            return getStatisticDAO().update(converter(statistic,statisticEntity));
        }
    }
    Statistic converter(Statistic statistic, Statistic statisticEntity){
        statisticEntity.setBudget(statistic.getBudget());
        statisticEntity.setBoxOffice(statistic.getBoxOffice());
        return statisticEntity;
    }

    @Override
    public Statistic create(Statistic statistic) {
        return getStatisticDAO().create(statistic);
    }

    @Override
    public void delete(long id) {
        System.out.println(getStatisticDAO().delete(id) ? "Deleted" : "Error");
    }
}
