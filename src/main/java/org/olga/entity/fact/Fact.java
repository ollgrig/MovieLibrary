package org.olga.entity.fact;

import org.olga.entity.Entity;

public interface Fact extends Entity {
    String getFactText();

    void setFactText(String factText);
}