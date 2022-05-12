package pl.britenet.campus.builder;

import pl.britenet.campus.obj.model.CardProduct;

public class CardProductBuilder {
    private final CardProduct cardProduct;

    public CardProductBuilder(int id) {
        this.cardProduct = new CardProduct(id);
    }

    public CardProductBuilder setCardId(int card_id) {
        this.cardProduct.setCard_id(card_id);
        return this;
    }

    public CardProductBuilder setProductId(int product_id) {
        this.cardProduct.setProduct_id(product_id);
        return this;
    }

    public CardProductBuilder setQuantity(int quantity) {
        this.cardProduct.setQuantity(quantity);
        return this;
    }

    public CardProduct getCardProduct() {
        return this.cardProduct;
    }
}
