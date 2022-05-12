package pl.britenet.campus.service;

import pl.britenet.campus.obj.model.Discount;

import java.util.*;

public class DiscountService {

    private final Map<Integer, Discount> discounts;

    public DiscountService() {
        this.discounts = new HashMap<>();
    }

    public Optional<Discount> retrieve(int id) {
        return Optional.of(this.discounts.get(id));
    }

    public Discount create(Discount discount) {
        this.discounts.put(discount.getId(), discount);
        return discount;
    }

    public void remove(int id) {
        this.discounts.remove(id);
    }

    public Discount update(Discount discount) {
        if (this.discounts.containsKey(discount.getId())) {
            this.discounts.replace(discount.getId(), discount);
            return discount;
        }
        else {
            throw new IllegalStateException("No such element under the given ID");
        }
    }

    public void display(int id){
        Discount discount = this.retrieve(id).orElseThrow();
        System.out.println(discount);
    }

//    public void display(){
//        for (Discount discount : this.discounts){
//            System.out.println(discount);
//        }
//    }
}
