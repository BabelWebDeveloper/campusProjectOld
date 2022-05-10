package pl.britenet.campus.service;

import pl.britenet.campus.obj.model.Card;
import pl.britenet.campus.obj.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService {

    private final List<Customer> customers;

    public CustomerService() {
        this.customers = new ArrayList<>();
    }

    public Optional<Customer> retrieve(int id) {
        return this.customers.stream()
                .filter( customer -> customer.getId() == id )
                .findFirst();
    }

    public Customer create(int id, String first_name, String last_name, String phone, String email, String street, String city, int zip_code) {
        Customer customer = new Customer(id);
        customer.setFirst_name(first_name);
        customer.setLast_name(last_name);
        customer.setPhone(phone);
        customer.setEmail(email);
        customer.setStreet(street);
        customer.setCity(city);
        customer.setZip_code(zip_code);
        this.customers.add(customer);
        return customer;
    }

    public void remove(int id) {
        this.customers.removeIf(category -> category.getId() == id );
    }

    public Customer update(int id, String first_name, String last_name, String phone, String email, String street, String city, int zip_code) {
        Customer customer = this.retrieve(id).orElseThrow();
        customer.setFirst_name(first_name);
        customer.setLast_name(last_name);
        customer.setPhone(phone);
        customer.setEmail(email);
        customer.setStreet(street);
        customer.setCity(city);
        customer.setZip_code(zip_code);
        return customer;
    }

    public void display(int id){
        Customer customer = this.retrieve(id).orElseThrow();
        System.out.println("Name: " + customer.getFirst_name() + " " + customer.getLast_name() + " " + customer.getEmail());
    }

    public void display(){
        for (Customer customer : this.customers){
            System.out.println("Name: " + customer.getFirst_name() + " " + customer.getLast_name() + " " + customer.getEmail());
        }
    }
}
