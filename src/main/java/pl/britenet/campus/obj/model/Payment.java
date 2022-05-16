package pl.britenet.campus.obj.model;

public class Payment {
    private int id;
    private int customer_id;
    private String date;

    public Payment(int id) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    @Override
    public String toString() {
        return String.format("ID: %d, customer-id: %d, date: %s", id, customer_id, date);
    }
}
