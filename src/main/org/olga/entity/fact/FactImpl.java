package org.olga.entity.fact;

import org.olga.entity.EntityImpl;

public class FactImpl extends EntityImpl implements Fact {
    private long id;
    private String factText;

    @Override
    public String getFactText() {
        return factText;
    }

    @Override
    public void setFactText(String factText) {
        this.factText = factText;
    }
}
