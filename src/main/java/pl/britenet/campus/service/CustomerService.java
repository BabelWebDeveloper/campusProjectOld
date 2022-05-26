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

    public List<Customer> retrieveAll() {
        String sqlQuery = "SELECT * FROM customer";

        try {
            return this.databaseService.performQuery(sqlQuery, resultSet -> {

                List<Customer> customers = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");

                    Customer customer = new CustomerBuilder(id)
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setEmail(email)
                            .setAddress(address)
                            .getCustomer();

                    customers.add(customer);
                }

                return customers;

            });
        } catch (RuntimeException exception) {
            System.out.println("ERROR!");
            System.out.println(exception.getMessage());

            return new ArrayList<>();
        }
    }
    public Optional<Customer> retrieve(int id) {
        String sqlQuery = String.format("SELECT * FROM customer WHERE id=%d", id);
        try {
            Customer customer = this.databaseService.performQuery(sqlQuery, resultSet -> {

                if (resultSet.next()) {
                    String first_name = resultSet.getString("first_name");
                    String last_name = resultSet.getString("last_name");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");

                    return new CustomerBuilder(id)
                            .setFirstName(first_name)
                            .setLastName(last_name)
                            .setEmail(email)
                            .setAddress(address)
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
