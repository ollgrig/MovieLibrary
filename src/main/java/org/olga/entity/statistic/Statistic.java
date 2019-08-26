package org.olga.entity.statistic;

import org.olga.entity.Entity;
import org.olga.entity.film.Film;

import java.util.List;

public interface Statistic extends Entity {
    double getBudget();

    void setBudget(double budget);

    double getBoxOffice();

    void setBoxOffice(double boxOffice);

    List<Film> getFilmList();

    void setFilmList(List<Film> filmList);
}
