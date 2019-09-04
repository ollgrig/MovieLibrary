package org.olga.service.fact;

import org.olga.entity.fact.Fact;
import org.olga.entity.film.Film;
import org.olga.repository.fact.FactDAO;
import org.olga.repository.factory.DAOFactory;
import org.olga.service.film.FilmService;

import java.util.List;

import static java.util.Objects.isNull;

public class FactServiceImpl implements FactService {
    private FactDAO factDAO;

    FactDAO getFactDAO() {
        if (isNull(factDAO)) {
            factDAO = DAOFactory.getDAO(FactDAO.class);
        }
        return factDAO;
    }

    @Override
    public Fact getFactById(long id) {
        return getFactDAO().getById(id);
    }

    @Override
    public List<Fact> getAllFacts() {
        return getFactDAO().getAll();
    }

    @Override
    public Fact update(Fact fact) {
        Fact factEntity = getFactById(fact.getId());
        if (fact.equals(factEntity)) {
            return factEntity;
        } else {
            return getFactDAO().update(converter(fact, factEntity));
        }
    }

    Fact converter(Fact fact, Fact factEntity) {
        factEntity.setFactText(fact.getFactText());
        return factEntity;
    }

    @Override
    public Fact create(Fact fact) {
        return getFactDAO().create(fact);
    }

    @Override
    public void delete(long id) {
        System.out.println(getFactDAO().delete(id) ? "Deleted" : "Error");
    }
}
