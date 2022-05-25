package pl.britenet.campus.obj.model;

public class CartProduct {
    private int id;
    private int cartId;
    private int productId;

    private int quantity;

//    private Category category;
//    private Product product;

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

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    @Override
    public String toString() {
        return String.format("card_id: %s, product_id: %s , quantity: %s", cartId, productId, quantity);
//        return String.format("Nazwa produktu: %s, Ilość: %s, Nazwa kategorii: %s", product.getName(), quantity, category.getName());
    }
}
