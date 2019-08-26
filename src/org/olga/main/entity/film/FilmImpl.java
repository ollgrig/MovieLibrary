package entity.film;

import entity.fact.Fact;

import java.util.List;

public class FilmImpl implements Film {
    private int id;
    private String name;
    private int statisticId;
    private List<Fact> factList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
