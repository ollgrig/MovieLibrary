package entity.film;

import entity.fact.Fact;

import java.util.List;

public interface Film {
    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    int getStatisticId();

    void setStatisticId(int statisticId);

    List<Fact> getFactList();

    void setFactList(List<Fact> factList);
}