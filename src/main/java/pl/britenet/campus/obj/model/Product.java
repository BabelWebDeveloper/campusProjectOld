package pl.britenet.campus.obj.model;

public class Product {

    private final int id;
    private String name;
    private String description;
    private double price;
    private int discountId;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, name: %s, description: %s, price: %f, category_id: %s, discount_id: %s", id, name, description, price, categoryId, discountId);
    }

}
