package pl.britenet.campus.obj.model;

import java.util.Date;

public class Payment {
    private int id;
    private int cardId;
    private String date;

    private Product product;
    private Cart cart;
    private CartProduct cartProduct;
    private Customer customer;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public CartProduct getCartProduct() {
        return cartProduct;
    }

    public void setCartProduct(CartProduct cartProduct) {
        this.cartProduct = cartProduct;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return String.format("nazwa produktu: %s", product.getName());
    }
}
