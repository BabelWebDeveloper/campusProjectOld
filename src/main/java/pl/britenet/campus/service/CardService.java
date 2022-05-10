package pl.britenet.campus.service;

import pl.britenet.campus.obj.model.Card;
import pl.britenet.campus.obj.model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CardService {

    private final List<Card> cards;

    public CardService() {
        this.cards = new ArrayList<>();
    }

    public Optional<Card> retrieve(int id) {
        return this.cards.stream()
                .filter( card -> card.getId() == id )
                .findFirst();
    }

    public Card create(int id, int customer_id, double total_cost) {
        Card card = new Card(id);
        card.setCustomer_id(customer_id);
        card.setTotal_cost(total_cost);
        this.cards.add(card);
        return card;
    }

    public void remove(int id) {
        this.cards.removeIf(category -> category.getId() == id );
    }

    public Card update(int id, int customer_id, double total_cost) {
        Card card = this.retrieve(id).orElseThrow();
        card.setCustomer_id(customer_id);
        card.setTotal_cost(total_cost);
        return card;
    }

    public void display(int id){
        Card card = this.retrieve(id).orElseThrow();
        System.out.println("User id of this card: " + card.getCustomer_id());
    }

    public void display(){
        for (Card card : this.cards){
            System.out.println("User id of this card: " + card.getCustomer_id());
        }
    }
}
