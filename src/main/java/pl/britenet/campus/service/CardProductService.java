package pl.britenet.campus.service;

import pl.britenet.campus.obj.model.Card;
import pl.britenet.campus.obj.model.CardProduct;
import pl.britenet.campus.obj.model.Product;

import java.util.*;

public class CardProductService {

    private final Map<Integer, CardProduct> cardProducts;

    public CardProductService() {
        this.cardProducts = new HashMap<>();
    }

    public Optional<CardProduct> retrieve(int id) {
        return Optional.of(this.cardProducts.get(id));
    }

    public CardProduct create(CardProduct cardProduct) {
        this.cardProducts.put(cardProduct.getId(), cardProduct);
        return cardProduct;
    }

    public void remove(int id) {
        this.cardProducts.remove(id);
    }

    public CardProduct update(CardProduct cardProduct) {
        if (this.cardProducts.containsKey(cardProduct.getId())) {
            this.cardProducts.replace(cardProduct.getId(), cardProduct);
            return cardProduct;
        }
        else {
            throw new IllegalStateException("No such element under the given ID");
        }
    }

    public void display(int id){
        CardProduct cardProduct = this.retrieve(id).orElseThrow();
        System.out.println(cardProduct);
    }

//    public void display(){
//        for (CardProduct cardProduct : this.cardProducts){
//            System.out.println(cardProduct);
//        }
//    }
}
