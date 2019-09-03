package org.olga.repository.factory;

import org.olga.repository.DataAccessObject;
import org.olga.repository.actor.ActorDAO;
import org.olga.repository.actor.ActorDAOImpl;
import org.olga.repository.fact.FactDAO;
import org.olga.repository.fact.FactDAOImpl;
import org.olga.repository.film.FilmDAO;
import org.olga.repository.film.FilmDAOImpl;
import org.olga.repository.statistic.StatisticDAO;
import org.olga.repository.statistic.StatisticDAOImpl;

public class DAOFactory {
    @SuppressWarnings("unchecked")
    public static <T extends DataAccessObject> T getDAO(Class<T> entityDAOClass) {
        if (entityDAOClass.equals(ActorDAO.class)) {
            return (T) new ActorDAOImpl();
        }else if (entityDAOClass.equals(FactDAO.class)) {
            return (T) new FactDAOImpl();
        }if (entityDAOClass.equals(FilmDAO.class)) {
            return (T) new FilmDAOImpl();
        }if (entityDAOClass.equals(StatisticDAO.class)) {
            return (T) new StatisticDAOImpl();
        }else return null;
    }
}
