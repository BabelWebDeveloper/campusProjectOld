package pl.britenet.campus.obj.categoryCommands;

import pl.britenet.campus.builder.CategoryBuilder;
import pl.britenet.campus.obj.Command;
import pl.britenet.campus.obj.model.Category;
import pl.britenet.campus.obj.model.Product;
import pl.britenet.campus.service.CategoryService;
import pl.britenet.campus.service.ProductService;

import java.util.Scanner;

public class CreateCategoryCommand extends Command {
    private final CategoryService categoryService;

    public CreateCategoryCommand(CategoryService categoryService) {
        super("create-category");

        this.categoryService = categoryService;
    }

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź ID kategorii, którą chcesz dodać:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wprowadź nazwę kategorii:");
        String name = scanner.nextLine();

        Category category = new CategoryBuilder(id)
                .setName(name)
                .getCategory();
        categoryService.create(category);

        category = categoryService.retrieve(id).orElseThrow();
        System.out.println(category);
    }
}
