package pl.britenet.campus.service;

import pl.britenet.campus.builder.CategoryBuilder;
import pl.britenet.campus.builder.ProductBuilder;
import pl.britenet.campus.obj.model.Category;
import pl.britenet.campus.obj.model.Product;
import pl.britenet.campus.service.database.DatabaseService;

import java.util.*;

public class ProductService {

    private final DatabaseService databaseService;

    public ProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Optional<Product> retrieve(int id) {
        String sqlQuery = String.format("SELECT p.id, p.name, p.description, p.categoryId, p.discountId, p.price, c.name AS categoryName FROM product p INNER JOIN category c ON p.categoryId = c.id WHERE p.id=%d", id);

        try {
            Product product = this.databaseService.performQuery(sqlQuery, resultSet -> {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    double price = resultSet.getDouble("price");
                    int discount_id = resultSet.getInt("discountId");
                    int category_id = resultSet.getInt("categoryId");
                    String categoryName = resultSet.getString("categoryName");

                    Category category = new CategoryBuilder(category_id)
                            .setName(categoryName)
                            .getCategory();

                    return new ProductBuilder(id)
                            .setName(name)
                            .setDescription(description)
                            .setPrice(price)
                            .setDiscount(discount_id)
                            .setCategoryId(category_id)
                            .setCategory(category)
                            .getProduct();
                }
                return null;

            });

            return Optional.of(product);

        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
            return Optional.empty();
        }

    }

    public Product create(Product product) {
        String dml = String.format("INSERT INTO product (name, description, price, discountId, categoryId) VALUES ('%s', '%s', %s, %d, %d)",
                product.getName(),
                product.getDescription(),
                String.valueOf(product.getPrice()).replace(",","."),
                product.getDiscountId(),
                product.getCategoryId());

        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(dml);
            System.out.println(e.getMessage());
        }
        return product;
    }

    public void remove(int id) {
        String dml = String.format("DELETE FROM product WHERE id=%d", id);
        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
    }

    public Product update(Product product) {
        String dml = String.format("UPDATE product SET name='%s', description='%s', price=%s, discountId=%d, categoryId=%d WHERE id=%d",
                product.getName(),
                product.getDescription(),
                String.valueOf(product.getPrice()).replace(",","."),
                product.getDiscountId(),
                product.getCategoryId(),
                product.getId());

        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
        return product;
    }

    public void display(int id){
        try {
            Product product = this.retrieve(id).orElseThrow();
            System.out.println(product);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

//    public void display(){
//        for (Product product : this.products){
//            System.out.println(product);
//        }
//    }
}
