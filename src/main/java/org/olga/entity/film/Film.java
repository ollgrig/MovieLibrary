package org.olga.entity.film;

import org.olga.entity.Entity;
import org.olga.entity.fact.Fact;

import java.util.List;

public interface Film extends Entity {
    String getName();

    void setName(String name);

    long getStatisticId();

    void setStatisticId(long statisticId);

    List<Fact> getFactList();

    void setFactList(List<Fact> factList);
}