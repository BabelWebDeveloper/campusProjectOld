package pl.britenet.campus.builder;

import pl.britenet.campus.obj.model.Payment;

public class PaymentBuilder {
    private final Payment payment;

    public PaymentBuilder(int id) {
        this.payment = new Payment(id);
    }

    public PaymentBuilder setCartId(int cardId) {
        this.payment.setCardId(cardId);
        return this;
    }

    public PaymentBuilder setDate(String date) {//tutaj musi się zmienić na date
        this.payment.setDate(date);
        return this;
    }

    public Payment getPayment() {
        return this.payment;
    }

}
