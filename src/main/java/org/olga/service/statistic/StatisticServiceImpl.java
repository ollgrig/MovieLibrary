package org.olga.service.statistic;

import org.olga.entity.statistic.Statistic;
import org.olga.repository.factory.DAOFactory;
import org.olga.repository.statistic.StatisticDAO;

import java.util.List;

public class StatisticServiceImpl implements StatisticService {
    private StatisticDAO statisticDAO = DAOFactory.getDAO(StatisticDAO.class);

    @Override
    public Statistic getStatisticById(long id) {
        return statisticDAO.getById(id);
    }

    @Override
    public List<Statistic> getAllStatistics() {
        return statisticDAO.getAll();
    }

    @Override
    public Statistic update(Statistic statistic) {
        Statistic statisticEntity = getStatisticById(statistic.getId());
        if (statistic.equals(statisticEntity)) {
            return statisticEntity;
        } else {
            // begin the logic of converter normally
            statisticEntity.setBudget(statistic.getBudget());
            statisticEntity.setBoxOffice(statistic.getBoxOffice());
            // end logic of converter
            return statisticDAO.update(statisticEntity);
        }
    }

    @Override
    public Statistic create(Statistic statistic) {
        return statisticDAO.create(statistic);
    }

    @Override
    public void delete(long id) {
        System.out.println(statisticDAO.delete(id) ? "Deleted" : "Error");
    }
}
