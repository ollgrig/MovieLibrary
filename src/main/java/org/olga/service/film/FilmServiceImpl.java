package org.olga.service.film;

import org.olga.entity.film.Film;
import org.olga.repository.factory.DAOFactory;
import org.olga.repository.film.FilmDAO;

import java.util.List;

import static java.util.Objects.isNull;

public class FilmServiceImpl implements FilmService {
    private FilmDAO filmDAO;

    @Override
    public Film getFilmById(long id) {
        return filmDAO.getById(id);
    }

    @Override
    public List<Film> getAllFilms() {
        return filmDAO.getAll();
    }

    @Override
    public Film update(Film film) {
        Film filmEntity = getFilmById(film.getId());
        if (film.equals(filmEntity)) {
            return filmEntity;
        } else {
            // begin the logic of converter normally
            filmEntity.setName(film.getName());
            filmEntity.setStatisticId(film.getStatisticId());
            filmEntity.setFactList(film.getFactList());
            // end logic of converter
            return getFilmDao().update(filmEntity);
        }
    }

    @Override
    public Film create(Film film) {
        return filmDAO.create(film);
    }

    @Override
    public void delete(long id) {
        System.out.println(filmDAO.delete(id)? "Deleted" : "Error");
    }

    FilmDAO getFilmDao() {
        if (isNull(filmDAO)) {
            filmDAO = DAOFactory.getDAO(FilmDAO.class);
        }
        return filmDAO;
    }
}
