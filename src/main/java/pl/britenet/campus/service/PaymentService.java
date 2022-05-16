package pl.britenet.campus.service;

import pl.britenet.campus.builder.PaymentBuilder;
import pl.britenet.campus.builder.ProductBuilder;
import pl.britenet.campus.obj.model.Payment;
import pl.britenet.campus.obj.model.Product;
import pl.britenet.campus.service.database.DatabaseService;

import java.util.*;

public class PaymentService {

    private final DatabaseService databaseService;

    public PaymentService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Optional<Payment> retrieve(int id) {
        String sqlQuery = String.format("SELECT * FROM payment WHERE id=%d", id);
        Payment payment = this.databaseService.performQuery(sqlQuery, resultSet -> {

            if (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                String date = resultSet.getString("date");

                return new PaymentBuilder(id)
                        .setCustomerId(customer_id)
                        .setDate(date)
                        .getPayment();
            }
            return null;

        });

        return Optional.of(payment);
    }

    public Payment create(Payment payment) {
        String dml = String.format("INSERT INTO payment (customer_id, date) VALUES (%d, '%s')",
                payment.getCustomer_id(),
                payment.getDate());

        this.databaseService.performDML(dml);
        return payment;
    }

    public void remove(int id) {
        String dml = String.format("DELETE FROM product WHERE id=%d", id);
        this.databaseService.performDML(dml);
    }

    public Payment update(Payment payment) {
        String dml = String.format("UPDATE payment SET customer_id=%d, date='%s' WHERE id=%d",
                payment.getCustomer_id(),
                payment.getDate(),
                payment.getId());

        this.databaseService.performDML(dml);
        return payment;
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
