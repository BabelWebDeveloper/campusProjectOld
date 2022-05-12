package pl.britenet.campus.service;

import pl.britenet.campus.obj.model.Customer;

import java.util.*;

public class CustomerService {

    private final Map<Integer, Customer> customers;

    public CustomerService() {
        this.customers = new HashMap<>();
    }

    public Optional<Customer> retrieve(int id) {
        return Optional.of(this.customers.get(id));
    }

    public Customer create(Customer customer) {
        this.customers.put(customer.getId(), customer);
        return customer;
    }

    public void remove(int id) {
        this.customers.remove(id);
    }

    public Customer update(Customer customer) {
        if (this.customers.containsKey(customer.getId())) {
            this.customers.replace(customer.getId(), customer);
            return customer;
        }
        else {
            throw new IllegalStateException("No such element under the given ID");
        }
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
