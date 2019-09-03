package org.olga.entity.film;

import org.olga.entity.EntityImpl;
import org.olga.entity.fact.Fact;

import java.util.List;
import java.util.Objects;

public class FilmImpl extends EntityImpl implements Film {
    private String name;
    private long statisticId;
    private List<Fact> factList;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getStatisticId() {
        return statisticId;
    }

    @Override
    public void setStatisticId(long statisticId) {
        this.statisticId = statisticId;
    }

    @Override
    public List<Fact> getFactList() {
        return factList;
    }

    @Override
    public void setFactList(List<Fact> factList) {
        this.factList = factList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmImpl film = (FilmImpl) o;
        return statisticId == film.statisticId &&
                Objects.equals(name, film.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, statisticId);
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", statisticId=" + statisticId +
                '}';
    }

}
