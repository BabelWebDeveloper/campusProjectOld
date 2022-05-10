package pl.britenet.campus.obj.model;

public class Order {
    private int id;
    private int card_id;
    private int payment_id;

    public Order(int card_id, int payment_id) {
        this.card_id = card_id;
        this.payment_id = payment_id;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }
}
