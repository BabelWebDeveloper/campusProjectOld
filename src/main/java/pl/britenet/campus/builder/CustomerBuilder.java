package pl.britenet.campus.builder;

import pl.britenet.campus.obj.model.Category;
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

    public CustomerBuilder setPhone(String phone) {
        this.customer.setPhone(phone);
        return this;
    }

    public CustomerBuilder setEmail(String email) {
        this.customer.setEmail(email);
        return this;
    }

    public CustomerBuilder setStreet(String street) {
        this.customer.setStreet(street);
        return this;
    }

    public CustomerBuilder setCity(String city) {
        this.customer.setCity(city);
        return this;
    }

    public CustomerBuilder setZipCode(int zip_code) {
        this.customer.setZip_code(zip_code);
        return this;
    }


    public Customer getCustomer() {
        return this.customer;
    }
}
