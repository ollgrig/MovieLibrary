package org.olga.entity.film;

import org.olga.entity.EntityImpl;
import org.olga.entity.fact.Fact;

import java.util.List;

public class FilmImpl extends EntityImpl {
    private int id;
    private String name;
    private int statisticId;
    private List<Fact> factList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatisticId() {
        return statisticId;
    }

    public void setStatisticId(int statisticId) {
        this.statisticId = statisticId;
    }

    public List<Fact> getFactList() {
        return factList;
    }

    public void setFactList(List<Fact> factList) {
        this.factList = factList;
    }

}
