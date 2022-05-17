package pl.britenet.campus.obj.model;

public class Discount {
    private int id;
    private int percent;
    private String description;

    public Discount(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
    @Override
    public String toString() {
        return String.format("discount-percent: %d, Description: %s", percent, description);
    }
}
