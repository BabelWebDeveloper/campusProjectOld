package pl.britenet.campus.obj.model;

import java.util.Date;

public class Payment {
    private int id;
    private int cardId;
    private String date;

    public Payment(int id) {
        this.id = id;
    }

    public Payment() {
        this.id = 0;
    }

    public int getId() {
        return id;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("card-id: %d", cardId);
    }
}
