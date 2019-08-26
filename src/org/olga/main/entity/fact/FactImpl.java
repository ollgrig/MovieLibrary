package entity.fact;

public class FactImpl implements Fact {
    private int id;
    private String factText;
    private int filmId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFactText() {
        return factText;
    }

    public void setFactText(String factText) {
        this.factText = factText;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
}
