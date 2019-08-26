package org.olga.entity.statistic;

import org.olga.entity.film.Film;

import java.util.List;

public interface Statistic {
    int getId();

    void setId(int id);

    int getBudget();

    void setBudget(int budget);

    int getBoxOffice();

    void setBoxOffice(int boxOffice);

    List<Film> getFilmList();

    void setFilmList(List<Film> filmList);
}
