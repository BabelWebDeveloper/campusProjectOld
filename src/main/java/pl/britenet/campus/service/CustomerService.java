package pl.britenet.campus.service;

import pl.britenet.campus.builder.CustomerBuilder;
import pl.britenet.campus.builder.PaymentBuilder;
import pl.britenet.campus.obj.model.Customer;
import pl.britenet.campus.obj.model.Payment;
import pl.britenet.campus.service.database.DatabaseService;

import java.util.*;

public class CustomerService {

    private final DatabaseService databaseService;

    public CustomerService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Optional<Customer> retrieve(int id) {
        String sqlQuery = String.format("SELECT * FROM payment WHERE id=%d", id);
        Customer customer = this.databaseService.performQuery(sqlQuery, resultSet -> {

            if (resultSet.next()) {
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String street = resultSet.getString("street");
                String city = resultSet.getString("city");
                int zip_code = resultSet.getInt("zip_code");

                return new CustomerBuilder(id)
                        .setFirstName(first_name)
                        .setLastName(last_name)
                        .setPhone(phone)
                        .setEmail(email)
                        .setStreet(street)
                        .setCity(city)
                        .setZipCode(zip_code)
                        .getCustomer();
            }
            return null;

        });

        return Optional.of(customer);
    }

    public Customer create(Customer customer) {
        String dml = String.format("INSERT INTO customer (first_name, last_name, phone, email, street, city, zip_code) VALUES ('%s','%s','%s','%s','%s','%s', %d)",
                customer.getFirst_name(),
                customer.getLast_name(),
                customer.getPhone(),
                customer.getEmail(),
                customer.getStreet(),
                customer.getCity(),
                customer.getZip_code());

        this.databaseService.performDML(dml);
        return customer;
    }

    public void remove(int id) {
        String dml = String.format("DELETE FROM customer WHERE id=%d", id);
        this.databaseService.performDML(dml);
    }

    public Customer update(Customer customer) {
        String dml = String.format("UPDATE customer SET first_name='%s', last_name='%s', phone='%s', email='%s', street='%s', city='%s', zip_code=%d WHERE id=%d",
                customer.getFirst_name(),
                customer.getLast_name(),
                customer.getPhone(),
                customer.getEmail(),
                customer.getStreet(),
                customer.getCity(),
                customer.getZip_code(),
                customer.getId());

        this.databaseService.performDML(dml);
        return customer;
    }

    public void display(int id){
        Customer customer = this.retrieve(id).orElseThrow();
        System.out.println(customer);
    }

//    public void display(){
//        for (Customer customer : this.customers){
//            System.out.println(customer);
//        }
//    }
}
