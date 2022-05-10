package pl.britenet.campus.obj;

import pl.britenet.campus.obj.model.Category;
import pl.britenet.campus.obj.model.Product;
import pl.britenet.campus.service.CommandService;

import java.util.Scanner;

public class CreateProductCommand extends Command {

    public CreateProductCommand() {
        super("create-product");
    }

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product id:");
        int product_id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter product name:");
        String product_name = scanner.nextLine();

        System.out.println("Enter product description:");
        String product_description = scanner.nextLine();

        System.out.println("Enter product category id:");
        int product_categoryId = scanner.nextInt();

        Product product = new Product(product_id);
        product.setName(product_name);
        product.setDescription(product_description);
        product.setCategoryId(product_categoryId);

        System.out.println("Product was successfully created. Type '/help' to show menu.");
    }

}
