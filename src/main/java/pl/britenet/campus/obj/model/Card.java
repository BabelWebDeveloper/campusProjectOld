package pl.britenet.campus.obj.model;

public class Card {
    private int id;
    private int customer_id;

    private int payment_id;
    private double total_cost;

    private boolean isOrdered;

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

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public boolean isOrdered() {
        return isOrdered;
    }



    public void setOrdered(boolean ordered) {
        isOrdered = ordered;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, customer_id: %d, total_cost: %f, idOrdered: %b", id, customer_id, total_cost, isOrdered);
    }
}
