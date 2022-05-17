package pl.britenet.campus.obj.model;

public class CartProduct {
    private int id;
    private int cartId;
    private int productId;

    private int quantity;

    public CartProduct(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCard_id() {
        return cartId;
    }

    public void setCard_id(int card_id) {
        this.cartId = card_id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("card_id: %s, product_id: %s , quantity: %s", cartId, productId, quantity);
    }
}
