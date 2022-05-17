package pl.britenet.campus.service;

import pl.britenet.campus.builder.CategoryBuilder;
import pl.britenet.campus.builder.ProductBuilder;
import pl.britenet.campus.obj.model.Category;
import pl.britenet.campus.obj.model.Product;
import pl.britenet.campus.service.database.DatabaseService;

import java.util.*;

public class CategoryService {

    private final DatabaseService databaseService;

    public CategoryService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Optional<Category> retrieve(int id) {
        String sqlQuery = String.format("SELECT * FROM category WHERE id=%d", id);

        try {
            Category category = this.databaseService.performQuery(sqlQuery, resultSet -> {

                if (resultSet.next()) {
                    String name = resultSet.getString("name");

                    return new CategoryBuilder(id)
                            .setName(name)
                            .getCategory();

                }
                return null;

            });

            return Optional.of(category);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
            return Optional.empty();
        }

    }

    public Category create(Category category) {
        String dml = String.format("INSERT INTO category (name) VALUES ('%s')",
                category.getName());

        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
        return category;
    }

    public void remove(int id) {
        String dml = String.format("DELETE FROM category WHERE id=%d", id);
        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
    }

    public Category update(Category category) {
        String dml = String.format("UPDATE category SET name='%s' WHERE id=%d",
                category.getName(),
                category.getId());

        try {
            this.databaseService.performDML(dml);
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
        return category;
    }

    public void display(int id){
        try {
            Category category = this.retrieve(id).orElseThrow();
            System.out.println(category);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

//    public void display(){
//        for (Category category : this.categories){
//            System.out.println(category);
//        }
//    }
}
