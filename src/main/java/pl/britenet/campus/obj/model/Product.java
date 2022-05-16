package pl.britenet.campus.obj.model;

public class Product {

    private final int id;
    private String name;
    private String description;
    private double price;
    private int discount_id;

    private int category_id;

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

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, name: %s, description: %s, price: %f, category_id: %s, discount_id: %s", id, name, description, price, category_id, discount_id);
    }

}
