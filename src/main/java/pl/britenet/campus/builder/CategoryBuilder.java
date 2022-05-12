package pl.britenet.campus.builder;

import pl.britenet.campus.obj.model.Category;

public class CategoryBuilder {
    private final Category category;

    public CategoryBuilder(int id) {
        this.category = new Category(id);
    }

    public CategoryBuilder setName(String name) {
        this.category.setName(name);
        return this;
    }

    public Category getCategory() {
        return this.category;
    }
}
