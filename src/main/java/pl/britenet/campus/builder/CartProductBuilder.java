package pl.britenet.campus.builder;

import pl.britenet.campus.obj.model.CartProduct;

public class CartProductBuilder {
    private final CartProduct cartProduct;

    public CartProductBuilder(int id) {
        this.cartProduct = new CartProduct(id);
    }

    public CartProductBuilder setCardId(int card_id) {
        this.cartProduct.setCard_id(card_id);
        return this;
    }

    public CartProductBuilder setProductId(int product_id) {
        this.cartProduct.setProductId(product_id);
        return this;
    }

    public CartProductBuilder setQuantity(int quantity) {
        this.cartProduct.setQuantity(quantity);
        return this;
    }

    public CartProduct getCardProduct() {
        return this.cartProduct;
    }
}
