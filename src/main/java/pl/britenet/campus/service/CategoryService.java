package pl.britenet.campus.service;

import pl.britenet.campus.obj.model.Category;
import pl.britenet.campus.obj.model.Product;

import java.util.*;

public class CategoryService {

    private final Map<Integer, Category> categories;

    public CategoryService() {
        this.categories = new HashMap<>();
    }

    public Optional<Category> retrieve(int id) {
        return Optional.of(this.categories.get(id));
    }

    public Category create(Category category) {
        this.categories.put(category.getId(), category);
        return category;
    }

    public void remove(int id) {
        this.categories.remove(id);
    }

    public Category update(Category category) {
        if (this.categories.containsKey(category.getId())){
            this.categories.replace(category.getId(), category);
            return category;
        }
        else {
            throw new IllegalStateException("No such element under the given ID");
        }
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
