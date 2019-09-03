package org.olga.constant.fact;

public class FactConstant {
    public static final String INSERT_FACT = "INSERT INTO fact (id, fact_text, film_id) VALUES (?, ?, ?)";
    public static final String SELECT_FACT_BY_ID = "SELECT id, fact_text, film_id FROM fact WHERE ID = ?";
    public static final String SELECT_ALL_FACT = "SELECT id, fact_text, film_id FROM fact";
    public static final String UPDATE_FACT = "UPDATE fact SET fact_text = ?, film_id = ? WHERE ID = ?";
    public static final String DELETE_FACT = "DELETE FROM fact WHERE ID = ?";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FACT_TEXT = "fact_text";

    private FactConstant() {
        throw new IllegalArgumentException("Should not be instantiated");
    }
}
