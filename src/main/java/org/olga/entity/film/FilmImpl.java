package org.olga.entity.film;

import org.olga.entity.EntityImpl;
import org.olga.entity.fact.Fact;

import java.util.List;

public class FilmImpl extends EntityImpl implements Film {
    private long id;
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

}
