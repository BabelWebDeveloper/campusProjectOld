package pl.britenet.campus.service;

import pl.britenet.campus.obj.model.Card;
import pl.britenet.campus.obj.model.Card;

import java.util.*;

public class CardService {

    private final Map<Integer, Card> cards;

    public CardService() {
        this.cards = new HashMap<>();
    }

    public Optional<Card> retrieve(int id) {
        return Optional.of(this.cards.get(id));
    }

    public Card create(Card card) {
        this.cards.put(card.getId(), card);
        return card;
    }

    public void remove(int id) {
        this.cards.remove(id);
    }

    public Card update(Card card) {
        if (this.cards.containsKey(card.getId())){
            this.cards.replace(card.getId(), card);
            return card;
        }
        else {
            throw new IllegalStateException("No such element under the given ID");
        }
    }

    public void display(int id){
        Card card = this.retrieve(id).orElseThrow();
        System.out.println(card);
    }

//    public void display(){
//        for (Card card : this.cards){
//            System.out.println("User id of this card: " + card.getCustomer_id());
//        }
//    }
}
