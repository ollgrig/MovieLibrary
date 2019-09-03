package org.olga.entity.fact;

import org.olga.entity.EntityImpl;

import java.util.Objects;

public class FactImpl extends EntityImpl implements Fact {
    private String factText;

    @Override
    public String getFactText() {
        return factText;
    }

    @Override
    public void setFactText(String factText) {
        this.factText = factText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactImpl fact = (FactImpl) o;
        return Objects.equals(factText, fact.factText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(factText);
    }

    @Override
    public String toString() {
        return "FactImpl{" +
                "factText='" + factText + '\'' +
                '}';
    }
}
