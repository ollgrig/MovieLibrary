package org.olga.constant.fact;

public class FactConstant {
    public static final String INSERT_FACT = "INSERT INTO fact (id, fact_text, film_id) VALUES (?, ?, ?)";
    public static final String SELECT_FACT_BY_ID = "SELECT id, fact_text, film_id FROM fact WHERE ID = ?";
    public static final String SELECT_ALL_FACT = "SELECT id, fact_text, film_id FROM fact";
    public static final String UPDATE_FACT = "UPDATE fact SET fact_text = ?, film_id = ? WHERE ID = ?";
}
