package org.olga.service.film;

import org.olga.entity.film.Film;
import org.olga.repository.factory.DAOFactory;
import org.olga.repository.film.FilmDAO;

import java.util.List;

import static java.util.Objects.isNull;

public class FilmServiceImpl implements FilmService {
    private FilmDAO filmDAO;

    FilmDAO getFilmDAO() {
        if (isNull(filmDAO)) {
            filmDAO = DAOFactory.getDAO(FilmDAO.class);
        }
        return filmDAO;
    }

    @Override
    public Film getFilmById(long id) {
        return getFilmDAO().getById(id);
    }

    @Override
    public List<Film> getAllFilms() {
        return getFilmDAO().getAll();
    }

    @Override
    public Film update(Film film) {
        Film filmEntity = getFilmById(film.getId());
        if (film.equals(filmEntity)) {
            return filmEntity;
        } else {
            return getFilmDAO().update(convert(film, filmEntity));
        }
    }

    Film convert(Film film, Film filmEntity) {
        filmEntity.setName(film.getName());
        filmEntity.setStatisticId(film.getStatisticId());
        filmEntity.setFactList(film.getFactList());
        return filmEntity;
    }

    @Override
    public Film create(Film film) {
        return getFilmDAO().create(film);
    }

    @Override
    public void delete(long id) {
        System.out.println(getFilmDAO().delete(id) ? "Deleted" : "Error");
    }


}
