package pl.britenet.campus.obj.model;

public class Product {

    private final int id;
    private String name;
    private String description;
    private double price;
    private int discount_id;

    private int categoryId;

    public Product(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscountId(int discount_id) {
        this.discount_id = discount_id;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, name: %s, description: %s, price: %f, category_id: %s", id, name, description, price, categoryId);
    }

}
