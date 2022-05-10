package pl.britenet.campus.obj.model;

public class Card {
    private int id;
    private int customer_id;
    private double total_cost;

    public Card(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }
}
