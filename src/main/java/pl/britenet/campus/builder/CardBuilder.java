package pl.britenet.campus.builder;

import pl.britenet.campus.obj.model.Card;

public class CardBuilder {
    private final Card card;

    public CardBuilder(int id) {
        this.card = new Card(id);
    }

    public CardBuilder setCustomerId(int customer_id) {
        this.card.setCustomer_id(customer_id);
        return this;
    }

    public CardBuilder setPaymentId(int paymentId) {
        this.card.setPayment_id(paymentId);
        return this;
    }

    public CardBuilder setTotalCost(double total_cost) {
        this.card.setTotal_cost(total_cost);
        return this;
    }

    public CardBuilder setOrdered(boolean ordered) {
        this.card.setOrdered(ordered);
        return this;
    }

    public Card getCard() {
        return this.card;
    }
}
