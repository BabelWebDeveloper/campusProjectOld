package pl.britenet.campus.service;

import pl.britenet.campus.builder.CardBuilder;
import pl.britenet.campus.builder.PaymentBuilder;
import pl.britenet.campus.obj.model.Card;
import pl.britenet.campus.obj.model.Payment;
import pl.britenet.campus.service.database.DatabaseService;

import java.util.*;

public class CardService {

    private final DatabaseService databaseService;

    public CardService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Optional<Card> retrieve(int id) {
        String sqlQuery = String.format("SELECT * FROM card WHERE id=%d", id);
        Card card = this.databaseService.performQuery(sqlQuery, resultSet -> {

            if (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int payment_id = resultSet.getInt("payment_id");
                double total_cost = resultSet.getInt("total_cost");
                boolean isOrdered = resultSet.getBoolean("isOrdered");

                return new CardBuilder(id)
                        .setCustomerId(customer_id)
                        .setPaymentId(payment_id)
                        .setTotalCost(total_cost)
                        .setOrdered(isOrdered)
                        .getCard();
            }
            return null;

        });

        return Optional.of(card);
    }

    public Card create(Card card) {
        String dml = String.format("INSERT INTO card (customer_id, payment_id , total_cost, isOrdered) VALUES (%d, %d, '%f', %b)",
                card.getCustomer_id(),
                card.getPayment_id(),
                card.getTotal_cost(),
                card.isOrdered());

        this.databaseService.performDML(dml);
        return card;
    }

    public void remove(int id) {
        String dml = String.format("DELETE FROM card WHERE id=%d", id);
        this.databaseService.performDML(dml);
    }

    public Card update(Card card) {
        String dml = String.format("UPDATE card SET customer_id=%d, payment_id=%d, total_cost='%f', isOrdered=%b WHERE id=%d",
                card.getCustomer_id(),
                card.getPayment_id(),
                card.getTotal_cost(),
                card.isOrdered(),
                card.getId());

        this.databaseService.performDML(dml);
        return card;
    }

    public void display(int id){
        Card card = this.retrieve(id).orElseThrow();
        System.out.println(card);
    }

//    public void display(){
//        for (Card card : this.cards){
//            System.out.println("User id of this card: " + card.getCustomer_id());
//        }
//    }
}
