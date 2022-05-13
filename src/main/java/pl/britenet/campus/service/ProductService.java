package pl.britenet.campus.service;

import pl.britenet.campus.obj.model.Product;

import java.util.*;

public class ProductService {

    private final Map<Integer, Product> products;

    public ProductService() {
        this.products = new HashMap<>();
    }

    public Optional<Product> retrieve(int id) {
        return Optional.of(this.products.get(id));
    }

    public Product create(Product product) {
        this.products.put(product.getId(), product);
        return product;
    }

    public void remove(int id) {
        this.products.remove(id);
    }

    public Product update(Product product) {
        if (this.products.containsKey(product.getId())) {
            this.products.replace(product.getId(), product);
            return product;
        }
        else {
            throw new IllegalStateException("No such element under the given ID");
        }
    }

    public void display(int id){
        Product product = this.retrieve(id).orElseThrow();
        System.out.println(product);
    }

//    public void display(){
//        for (Product product : this.products){
//            System.out.println(product);
//        }
//    }
}
