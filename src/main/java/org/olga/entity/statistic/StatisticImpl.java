package org.olga.entity.statistic;

import org.olga.entity.EntityImpl;
import org.olga.entity.film.Film;

import java.util.List;
import java.util.Objects;

public class StatisticImpl extends EntityImpl implements Statistic {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticImpl statistic = (StatisticImpl) o;
        return Double.compare(statistic.budget, budget) == 0 &&
                Double.compare(statistic.boxOffice, boxOffice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(budget, boxOffice);
    }

    @Override
    public String toString() {
        return "StatisticImpl{" +
                "filmList=" + filmList +
                '}';
    }
}
