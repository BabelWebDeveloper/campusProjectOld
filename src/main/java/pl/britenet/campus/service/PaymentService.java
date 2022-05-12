package pl.britenet.campus.service;

import pl.britenet.campus.obj.model.Payment;

import java.util.*;

public class PaymentService {

    private final Map<Integer, Payment> payments;

    public PaymentService() {
        this.payments = new HashMap<>();
    }

    public Optional<Payment> retrieve(int id) {
        return Optional.of(this.payments.get(id));
    }

    public Payment create(Payment payment) {
        this.payments.put(payment.getId(), payment);
        return payment;
    }

    public void remove(int id) {
        this.payments.remove(id);
    }

    public Payment update(Payment payment) {
        if (this.payments.containsKey(payment.getId())) {
            this.payments.replace(payment.getId(), payment);
            return payment;
        }
        else {
            throw new IllegalStateException("No such element under the given ID");
        }
    }

    public void display(int id){
        Payment payment = this.retrieve(id).orElseThrow();
        System.out.println(payment);
    }

//    public void display(){
//        for (Payment payment : this.payments){
//            System.out.println(payment);
//        }
//    }
}
