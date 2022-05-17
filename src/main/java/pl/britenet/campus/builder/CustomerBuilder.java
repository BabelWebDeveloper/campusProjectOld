package pl.britenet.campus.builder;

import pl.britenet.campus.obj.model.Customer;

public class CustomerBuilder {
    private final Customer customer;

    public CustomerBuilder(int id) {
        this.customer = new Customer(id);
    }

    public CustomerBuilder setFirstName(String name) {
        this.customer.setFirst_name(name);
        return this;
    }

    public CustomerBuilder setLastName(String name) {
        this.customer.setLast_name(name);
        return this;
    }

    public CustomerBuilder setEmail(String email) {
        this.customer.setEmail(email);
        return this;
    }

    public CustomerBuilder setAddress(String address) {
        this.customer.setAddress(address);
        return this;
    }


    public Customer getCustomer() {
        return this.customer;
    }
}
