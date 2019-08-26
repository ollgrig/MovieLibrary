package org.olga.entity.statistic;

import org.olga.entity.EntityImpl;
import org.olga.entity.film.Film;

import java.util.List;

public class StatisticImpl extends EntityImpl implements Statistic {
    private long id;
    private double budget;
    private double boxOffice;
    private List<Film> filmList;

    @Override
    public double getBudget() {
        return budget;
    }

    @Override
    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public double getBoxOffice() {
        return boxOffice;
    }

    @Override
    public void setBoxOffice(double boxOffice) {
        this.boxOffice = boxOffice;
    }

    @Override
    public List<Film> getFilmList() {
        return filmList;
    }

    @Override
    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }
}
