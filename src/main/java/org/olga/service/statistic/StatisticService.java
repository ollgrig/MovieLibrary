package org.olga.service.statistic;

import org.olga.entity.statistic.Statistic;

import java.util.List;

public interface StatisticService {
    Statistic getStatisticById(long id);

    List<Statistic> getAllStatistics();

    Statistic update(Statistic statistic);

    Statistic create(Statistic statistic);

    void delete(long id);
}
