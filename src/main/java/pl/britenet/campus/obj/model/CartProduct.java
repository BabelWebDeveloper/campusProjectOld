package pl.britenet.campus.obj.model;

public class CartProduct {
    private int id;
    private int cartId;
    private int productId;

    private int quantity;

    private Cart cart;
    private Product product;

    public CartProduct(int id) {
        this.id = id;
    }
    public CartProduct() {
        this.id = 0;
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

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return String.format("card_id: %s, nazwa produktu: %s , quantity: %s, cena : %.2f, totalprice: %.2f", cart.getId(), product.getName(), quantity, product.getPrice(), quantity * product.getPrice());
//        return String.format("Nazwa produktu: %s, Ilość: %s, Nazwa kategorii: %s", product.getName(), quantity, category.getName());
    }
}
