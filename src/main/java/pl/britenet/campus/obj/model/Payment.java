package pl.britenet.campus.obj.model;

public class Payment {
    private int id;
    private int customer_id;
    private int date;

    public Payment(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
