package org.olga.repository.factory;

import org.olga.repository.DataAccessObject;
import org.olga.repository.actor.ActorDAO;
import org.olga.repository.fact.FactDAO;
import org.olga.repository.film.FilmDAO;
import org.olga.repository.film.FilmDAOImpl;
import org.olga.repository.statistic.StatisticDAO;

public class DAOFactory {
    public static DataAccessObject getDAO(Class entityDAOClass) {
        if (entityDAOClass.equals(ActorDAO.class)) {
            return new FilmDAOImpl();
        } else if (entityDAOClass.equals(FactDAO.class)) {
            return new FilmDAOImpl();
        } else if (entityDAOClass.equals(FilmDAO.class)) {
            return new FilmDAOImpl();
        } else if (entityDAOClass.equals(StatisticDAO.class)) {
            return new FilmDAOImpl();
        } else return null;
    }
}
