package org.olga.service.fact;

import org.olga.entity.fact.Fact;

import java.util.List;

public interface FactService {
    Fact getFactById(long id);

    List<Fact> getAllFacts();

    Fact update(Fact fact);

    Fact create(Fact fact);

    void delete(long id);
}
