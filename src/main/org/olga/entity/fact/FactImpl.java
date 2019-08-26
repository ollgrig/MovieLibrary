package org.olga.entity.fact;

import org.olga.entity.EntityImpl;

public class FactImpl extends EntityImpl {
    private int id;
    private String factText;

    public String getFactText() {
        return factText;
    }

    public void setFactText(String factText) {
        this.factText = factText;
    }
}
