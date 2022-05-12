package pl.britenet.campus.builder;

import pl.britenet.campus.obj.model.Discount;

public class DiscountBuilder {
    private final Discount discount;

    public DiscountBuilder(int id) {
        this.discount = new Discount(id);
    }

    public DiscountBuilder setDiscountPercent(int discount_percent) {
        this.discount.setDiscount_percent(discount_percent);
        return this;
    }

    public DiscountBuilder setDescription(String descriptino) {
        this.discount.setDiscount_description(descriptino);
        return this;
    }

    public Discount getDiscount() {
        return this.discount;
    }
}
