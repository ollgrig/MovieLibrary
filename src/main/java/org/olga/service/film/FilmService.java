package org.olga.service.film;

import org.olga.entity.film.Film;

import java.util.List;

public interface FilmService {
    Film getFilmById(long id);

    List<Film> getAllFilms();

    Film update(Film film);

    Film create(Film film);

    void delete(long id);
}
