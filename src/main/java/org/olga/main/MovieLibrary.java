package org.olga.main;

import org.olga.entity.film.Film;
import org.olga.service.film.FilmService;
import org.olga.service.film.FilmServiseImpl;

public class MovieLibrary {
    public static void main(String[] args) {
        FilmService filmService = new FilmServiseImpl();
        for ( Film film : filmService.getAllFilms()) {
            System.out.println(film.getName());
        }
    }
}
