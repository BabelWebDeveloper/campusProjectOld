package pl.britenet.campus.builder;

import pl.britenet.campus.obj.model.Payment;

public class PaymentBuilder {
    private final Payment payment;

    public PaymentBuilder(int id) {
        this.payment = new Payment(id);
    }

    public PaymentBuilder setCustomerId(int customer_id) {
        this.payment.setCustomer_id(customer_id);
        return this;
    }

    public PaymentBuilder setDate(int date) {
        this.payment.setDate(date);
        return this;
    }

    public Payment getPayment() {
        return this.payment;
    }
}
