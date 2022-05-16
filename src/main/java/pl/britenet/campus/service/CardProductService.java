package pl.britenet.campus.service;

import pl.britenet.campus.builder.CardProductBuilder;
import pl.britenet.campus.builder.PaymentBuilder;
import pl.britenet.campus.obj.model.CardProduct;
import pl.britenet.campus.obj.model.Payment;
import pl.britenet.campus.service.database.DatabaseService;

import java.util.*;

public class CardProductService {

    private final DatabaseService databaseService;

    public CardProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Optional<CardProduct> retrieve(int id) {
        String sqlQuery = String.format("SELECT * FROM cardproduct WHERE id=%d", id);
        CardProduct cardProduct = this.databaseService.performQuery(sqlQuery, resultSet -> {

            if (resultSet.next()) {
                int card_id = resultSet.getInt("card_id");
                int product_id = resultSet.getInt("product_id");
                int quantity = resultSet.getInt("quantity");

                return new CardProductBuilder(id)
                        .setCardId(card_id)
                        .setProductId(product_id)
                        .setQuantity(quantity)
                        .getCardProduct();
            }
            return null;

        });

        return Optional.of(cardProduct);
    }

    public CardProduct create(CardProduct cardProduct) {
        String dml = String.format("INSERT INTO cardproduct (card_id, product_id, quantity) VALUES (%d, %d, %d)",
                cardProduct.getCard_id(),
                cardProduct.getProduct_id(),
                cardProduct.getQuantity());

        this.databaseService.performDML(dml);
        return cardProduct;
    }

    public void remove(int id) {
        String dml = String.format("DELETE FROM cardproduct WHERE id=%d", id);
        this.databaseService.performDML(dml);
    }

    public CardProduct update(CardProduct cardProduct) {
        String dml = String.format("UPDATE cardproduct SET card_id=%d, product_id=%d, quantity=%d WHERE id=%d",
                cardProduct.getCard_id(),
                cardProduct.getProduct_id(),
                cardProduct.getQuantity(),
                cardProduct.getId());

        this.databaseService.performDML(dml);
        return cardProduct;
    }

    public void display(int id){
        CardProduct cardProduct = this.retrieve(id).orElseThrow();
        System.out.println(cardProduct);
    }

//    public void display(){
//        for (CardProduct cardProduct : this.cardProducts){
//            System.out.println(cardProduct);
//        }
//    }
}
