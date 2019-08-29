package org.olga.service.film;

import org.olga.entity.film.Film;
import org.olga.repository.factory.DAOFactory;
import org.olga.repository.film.FilmDAO;

import java.util.List;

public class FilmServiseImpl implements FilmService {
    FilmDAO filmDAO = (FilmDAO) DAOFactory.getDAO(FilmDAO.class);

    @Override
    public Film getFilmById(long id) {
        return filmDAO.getById(id);
    }

    public Film update(Film film) {
        Film filmEntity = getFilmById(film.getId());
        // begin the logic of converter normally
        filmEntity.setName(film.getName());
        filmEntity.setStatisticId(film.getStatisticId());
        filmEntity.setFactList(film.getFactList());
        // end logic of converter
        return filmDAO.update(filmEntity);
    }

    public void printFilmById(long id) {
        System.out.println(getFilmById(id));
    }

    @Override
    public List<Film> getAllFilms() {
        return filmDAO.getAll();
    }
}
