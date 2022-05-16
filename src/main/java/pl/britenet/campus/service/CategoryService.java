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
    }

    public Category create(Category category) {
        String dml = String.format("INSERT INTO category (name) VALUES ('%s')",
                category.getName());

        this.databaseService.performDML(dml);
        return category;
    }

    public void remove(int id) {
        String dml = String.format("DELETE FROM category WHERE id=%d", id);
        this.databaseService.performDML(dml);
    }

    public Category update(Category category) {
        String dml = String.format("UPDATE category SET name='%s' WHERE id=%d",
                category.getName(),
                category.getId());

        this.databaseService.performDML(dml);
        return category;
    }

    public void display(int id){
        Category category = this.retrieve(id).orElseThrow();
        System.out.println(category);
    }

//    public void display(){
//        for (Category category : this.categories){
//            System.out.println(category);
//        }
//    }
}
