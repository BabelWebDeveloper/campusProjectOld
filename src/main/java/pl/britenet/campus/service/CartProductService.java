package pl.britenet.campus.service;

import pl.britenet.campus.builder.*;
import pl.britenet.campus.obj.model.*;
import pl.britenet.campus.service.database.DatabaseService;

import java.util.*;

public class CartProductService {

    private final DatabaseService databaseService;

    public CartProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<CartProduct> retrieveCartproducts(int cpId) {
        String sqlQuery = String.format("SELECT p.name AS productName, p.id AS productId, SUM(cp.quantity) AS quantity, c.id AS cartId, p.price AS price, SUM(cp.quantity) * price AS totalPrice\n" +
                "FROM product p\n" +
                "INNER JOIN cartproduct cp ON cp.productId = p.id\n" +
                "INNER JOIN cart c ON c.id = cp.cartId WHERE c.id = %d\n" +
                "GROUP BY p.name", cpId);


        try {
            return this.databaseService.performQuery(sqlQuery, resultSet -> {

                List<CartProduct> cartProductList = new ArrayList<>();
                while (resultSet.next()) {
                    int productId = resultSet.getInt("productId");
                    String productName = resultSet.getString("productName");
                    double productPrice = resultSet.getDouble("price");

                    int cpQuantity = resultSet.getInt("quantity");
                    int cartId = resultSet.getInt("cartId");

                    Cart cart = new CartBuilder(cartId)
                            .getCard();

                    Product product = new ProductBuilder(productId)
                            .setPrice(productPrice)
                            .setName(productName)
                            .getProduct();

                    CartProduct cartProduct = new CartProductBuilder(cpId)
                            .setQuantity(cpQuantity)
                            .setCart(cart)
                            .setProduct(product)
                            .getCardProduct();

                    cartProductList.add(cartProduct);
                }

                return cartProductList;

            });
        } catch (RuntimeException exception) {
            System.out.println("ERROR!");
            System.out.println(exception.getMessage());

            return new ArrayList<>();
        }
    }

    public Optional<CartProduct> retrieve(int id) {
        String sqlQuery = String.format("SELECT * FROM cartproduct WHERE id =%d", id);

        try {
            CartProduct cartProduct = this.databaseService.performQuery(sqlQuery, resultSet -> {

                if (resultSet.next()) {
                    int card_id = resultSet.getInt("cartId");
                    int product_id = resultSet.getInt("productId");
                    int quantity = resultSet.getInt("quantity");

                    return new CartProductBuilder(id)
                            .setCardId(card_id)
                            .setProductId(product_id)
                            .setQuantity(quantity)
                            .getCardProduct();
                }
                return null;

            });

            return Optional.of(cartProduct);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
            return Optional.empty();
        }

    }

    public CartProduct create(CartProduct cartProduct) {
        String dml = String.format("INSERT INTO cartproduct (cartId, productId, quantity) VALUES (%d, %d, %d)",
                cartProduct.getCard_id(),
                cartProduct.getProductId(),
                cartProduct.getQuantity());

        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
        return cartProduct;
    }

    public void remove(int id) {
        String dml = String.format("DELETE FROM cartproduct WHERE id=%d", id);
        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
    }

    public CartProduct update(CartProduct cartProduct) {
        String dml = String.format("UPDATE cartproduct SET cartId=%d, productId=%d, quantity=%d WHERE id=%d",
                cartProduct.getCard_id(),
                cartProduct.getProductId(),
                cartProduct.getQuantity(),
                cartProduct.getId());

        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
        return cartProduct;
    }

    public void display(int id){
        CartProduct cartProduct = this.retrieve(id).orElseThrow();
        System.out.println(cartProduct);
    }

//    public void display(){
//        for (CardProduct cardProduct : this.cardProducts){
//            System.out.println(cardProduct);
//        }
//    }
}
