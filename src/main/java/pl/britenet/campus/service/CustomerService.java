package pl.britenet.campus.service;

import pl.britenet.campus.builder.*;
import pl.britenet.campus.obj.model.*;
import pl.britenet.campus.service.database.DatabaseService;

import java.util.*;

public class CustomerService {

    private final DatabaseService databaseService;

    public CustomerService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Optional<Customer> retrieve(int id) {
        String sqlQuery = String.format("SELECT cr.first_name, cr.last_name, pr.name, cpr.quantity, cat.name, cat.id, pr.id, cr.email, cr.address, ca.id, cpr.quantity\n" +
                "FROM customer cr\n" +
                "INNER JOIN cart ca ON ca.customerId = cr.id\n" +
                "INNER JOIN cartproduct cpr ON ca.id = cpr.cartId\n" +
                "INNER JOIN product pr ON cpr.productId = pr.id\n" +
                "INNER JOIN category cat ON cat.id = pr.categoryId\n" +
                "WHERE cr.id = %d", id);
        try {
            Customer customer = this.databaseService.performQuery(sqlQuery, resultSet -> {

                if (resultSet.next()) {
                    String first_name = resultSet.getString("first_name");
                    String last_name = resultSet.getString("last_name");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");

                    int category_id = resultSet.getInt("cat.id");
                    String categoryName = resultSet.getString("cat.name");

                    int product_id = resultSet.getInt("pr.id");
                    String productName = resultSet.getString("pr.name");

                    int card_id = resultSet.getInt("ca.id");

                    int cp_quantity = resultSet.getInt("cpr.quantity");

                    Category category = new CategoryBuilder(category_id)
                            .setName(categoryName)
                            .getCategory();

                    Product product = new ProductBuilder(product_id)
                            .setName(productName)
                            .setCategoryId(category_id)
                            .getProduct();

                    CartProduct cartProduct = new CartProductBuilder(id)
                            .setCardId(card_id)
                            .setProductId(product_id)
                            .setQuantity(cp_quantity)
                            .setCategory(category)
                            .setProduct(product)
                            .getCardProduct();

                    Cart cart = new CartBuilder(id)
                            .getCard();

                    return new CustomerBuilder(id)
                            .setFirstName(first_name)
                            .setLastName(last_name)
                            .setEmail(email)
                            .setAddress(address)
                            .setCategory(category)
                            .setProduct(product)
                            .setCart(cart)
                            .setCartProduct(cartProduct)
                            .getCustomer();
                }
                return null;

            });

            return Optional.of(customer);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
            return Optional.empty();
        }

    }

    public Customer create(Customer customer) {
        String dml = String.format("INSERT INTO customer (first_name, last_name, email, address) VALUES ('%s','%s','%s','%s')",
                customer.getFirst_name(),
                customer.getLast_name(),
                customer.getEmail(),
                customer.getAddress());

        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
        return customer;
    }

    public void remove(int id) {
        String dml = String.format("DELETE FROM customer WHERE id=%d", id);
        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
    }

    public Customer update(Customer customer) {
        String dml = String.format("UPDATE customer SET first_name='%s', last_name='%s', email='%s', address='%s' WHERE id=%d",
                customer.getFirst_name(),
                customer.getLast_name(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getId());

        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
        return customer;
    }

    public void display(int id){
        try {
            Customer customer = this.retrieve(id).orElseThrow();
            System.out.println(customer);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

//    public void display(){
//        for (Customer customer : this.customers){
//            System.out.println(customer);
//        }
//    }
}
