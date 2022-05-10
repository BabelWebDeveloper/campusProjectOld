package pl.britenet.campus.service;

import pl.britenet.campus.obj.model.Category;
import pl.britenet.campus.obj.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryService {

    private final List<Category> categories;

    public CategoryService() {
        this.categories = new ArrayList<>();
    }

    public Optional<Category> retrieve(int id) {
        return this.categories.stream()
                .filter( category -> category.getId() == id )
                .findFirst();
    }

    public Category create(int id, String name) {
        Category category = new Category(id);
        category.setName(name);
        this.categories.add(category);
        return category;
    }

    public void remove(int id) {
        this.categories.removeIf( category -> category.getId() == id );
    }

    public Category update(int id, String name) {
        Category category = this.retrieve(id).orElseThrow();
        category.setName(name);
        return category;
    }

    public void display(int id){
        Category category = this.retrieve(id).orElseThrow();
        System.out.println(category.getName());
    }

    public void display(){
        for (Category category : this.categories){
            System.out.println(category.getName());
        }
    }
}
