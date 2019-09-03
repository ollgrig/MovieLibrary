package org.olga.constant.statistic;

public class StatisticConstant {
    public static final String INSERT_STATISTIC = "INSERT INTO statistic (id, budget, box_office) VALUES (?, ?, ?)";
    public static final String SELECT_STATISTIC_BY_ID = "SELECT id, budget, box_office FROM statistic WHERE ID = ?";
    public static final String SELECT_ALL_STATISTIC = "SELECT id, budget, box_office FROM statistic";
    public static final String UPDATE_STATISTIC = "UPDATE statistic SET budget = ?, box_office = ? WHERE ID = ?";
    public static final String DELETE_STATISTIC= "DELETE FROM statistic WHERE ID = ?";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_BUDGET = "budget";
    public static final String COLUMN_BOX_OFFICE = "box_office";

    private StatisticConstant() {
        throw new IllegalArgumentException("Should not be instantiated");
    }
}
