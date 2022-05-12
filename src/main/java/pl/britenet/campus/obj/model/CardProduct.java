package pl.britenet.campus.obj.model;

public class CardProduct {
    private int id;
    private int card_id;
    private int product_id;

    private int quantity;

    public CardProduct(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, card_id: %s, product_id: %s , quantity: %s", id, card_id, product_id, quantity);
    }
}
