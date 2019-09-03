package org.olga.service.fact;

import org.olga.entity.fact.Fact;
import org.olga.entity.film.Film;
import org.olga.repository.fact.FactDAO;
import org.olga.repository.factory.DAOFactory;
import org.olga.service.film.FilmService;

import java.util.List;

public class FactServiceImpl implements FactService {
    private FactDAO factDAO = DAOFactory.getDAO(FactDAO.class);
    @Override
    public Fact getFactById(long id) {
        return factDAO.getById(id);
    }

    @Override
    public List<Fact> getAllFacts() {
        return factDAO.getAll();
    }

    @Override
    public Fact update(Fact fact) {
        Fact factEntity = getFactById(fact.getId());
        if (fact.equals(factEntity)) {
            return factEntity;
        } else {
            // begin the logic of converter normally
            factEntity.setFactText(fact.getFactText());
            // end logic of converter
            return factDAO.update(factEntity);
        }
    }

    @Override
    public Fact create(Fact fact) {
        return factDAO.create(fact);
    }

    @Override
    public void delete(long id) {
        System.out.println(factDAO.delete(id)? "Deleted" : "Error");
    }
}
