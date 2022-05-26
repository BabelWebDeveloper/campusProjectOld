package pl.britenet.campus.service;

import pl.britenet.campus.builder.CartBuilder;
import pl.britenet.campus.builder.CartProductBuilder;
import pl.britenet.campus.obj.model.Cart;
import pl.britenet.campus.obj.model.CartProduct;
import pl.britenet.campus.service.database.DatabaseService;

import java.util.*;

public class CartService {

    private final DatabaseService databaseService;

    public CartService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<Cart> retrieveAll() {
        String sqlQuery = "SELECT * FROM cart";

        try {
            return this.databaseService.performQuery(sqlQuery, resultSet -> {

                List<Cart> cartList = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int customerId = resultSet.getInt("customerId");
                    double totalCost = resultSet.getDouble("total_cost");
                    boolean isOrdered = resultSet.getBoolean("isOrdered");

                    Cart cart = new CartBuilder(id)
                            .setCustomerId(customerId)
                            .setTotal_Cost(totalCost)
                            .setOrdered(isOrdered)
                            .getCard();

                    cartList.add(cart);
                }

                return cartList;

            });
        } catch (RuntimeException exception) {
            System.out.println("ERROR!");
            System.out.println(exception.getMessage());

            return new ArrayList<>();
        }
    }

    public Optional<Cart> retrieve(int id) {
        String sqlQuery = String.format("SELECT * FROM cart WHERE id=%d", id);

        try {
            Cart cart = this.databaseService.performQuery(sqlQuery, resultSet -> {

                if (resultSet.next()) {
                    int customer_id = resultSet.getInt("customerId");
                    double total_cost = resultSet.getDouble("total_cost");//przecinek zamienić na kropkę
                    boolean isOrdered = resultSet.getBoolean("isOrdered");

                    return new CartBuilder(id)
                            .setCustomerId(customer_id)
                            .setTotal_Cost(total_cost)
                            .setOrdered(isOrdered)
                            .getCard();
                }
                return null;

            });

            return Optional.of(cart);

        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public Cart create(Cart cart) {
        String dml = String.format("INSERT INTO cart (customerId, total_cost, isOrdered) VALUES (%d, %s, %b)",
                cart.getCustomerId(),
                String.valueOf(cart.getTotal_cost()).replace(",","."),
                cart.isOrdered());
        System.out.println(dml);
        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
        return cart;
    }

    public void remove(int id) {
        String dml = String.format("DELETE FROM cart WHERE id=%d", id);
        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
    }

    public Cart update(Cart cart) {
        String dml = String.format("UPDATE cart SET customerId=%d, total_cost=%s, isOrdered=%b WHERE id=%d",
                cart.getCustomerId(),
                String.valueOf(cart.getTotal_cost()).replace(",","."),
                cart.isOrdered(),
                cart.getId());

        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
        return cart;
    }

    public void display(int id){
        try {
            Cart cart = this.retrieve(id).orElseThrow();
            System.out.println(cart);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

//    public void display(){
//        for (Card card : this.cards){
//            System.out.println("User id of this card: " + card.getCustomer_id());
//        }
//    }
}
