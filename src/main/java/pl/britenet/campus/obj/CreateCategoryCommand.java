package pl.britenet.campus.obj;

import pl.britenet.campus.obj.model.Category;
import pl.britenet.campus.obj.model.Product;

import java.util.Scanner;

public class CreateCategoryCommand extends Command {

    public CreateCategoryCommand() {
        super("create-category");
    }

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter category id:");
        int category_id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter category name:");
        String category_name = scanner.nextLine();

        Category category = new Category(category_id);
        category.setName(category_name);

        System.out.println("Product was successfully created. Type '/help' to show menu.");
    }

}
