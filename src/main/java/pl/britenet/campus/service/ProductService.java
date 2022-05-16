package pl.britenet.campus.service;

import pl.britenet.campus.builder.ProductBuilder;
import pl.britenet.campus.obj.model.Product;
import pl.britenet.campus.service.database.DatabaseService;

import java.sql.SQLException;
import java.util.*;

public class ProductService {

    private final DatabaseService databaseService;

    public ProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Optional<Product> retrieve(int id) {
        String sqlQuery = String.format("SELECT * FROM product WHERE id=%d", id);
        Product product = this.databaseService.performQuery(sqlQuery, resultSet -> {

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                int discount_id = resultSet.getInt("discount_id");
                int category_id = resultSet.getInt("category_id");

                return new ProductBuilder(id)
                        .setName(name)
                        .setDescription(description)
                        .setPrice(price)
                        .setDiscount(discount_id)
                        .setCategoryId(category_id)
                        .getProduct();
            }
            return null;

        });

        return Optional.of(product);
    }

    public Product create(Product product) {
        String dml = String.format("INSERT INTO product (name, description, price, discount_id, category_id) VALUES ('%s', '%s', %f, %d, %d)",
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getDiscount_id(),
                product.getCategory_id());

        this.databaseService.performDML(dml);
        return product;
    }

    public void remove(int id) {
        String dml = String.format("DELETE FROM product WHERE id=%d", id);
        this.databaseService.performDML(dml);
    }

    public Product update(Product product) {
        String dml = String.format("UPDATE product SET name='%s', description='%s', price='%f', discount_id=%d, category_id=%d WHERE id=%d",
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getDiscount_id(),
                product.getCategory_id(),
                product.getId());

        this.databaseService.performDML(dml);
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
