package pl.britenet.campus.obj.model;

public class Discount {
    private int id;
    private int discount_percent;
    private String discount_description;

    public Discount(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDiscount_description() {
        return discount_description;
    }

    public void setDiscount_description(String discount_description) {
        this.discount_description = discount_description;
    }

    public int getDiscount_percent() {
        return discount_percent;
    }

    public void setDiscount_percent(int discount_percent) {
        this.discount_percent = discount_percent;
    }
    @Override
    public String toString() {
        return String.format("ID: %d, discount-percent: %d, Description: %s", id, discount_percent, discount_description);
    }
}
