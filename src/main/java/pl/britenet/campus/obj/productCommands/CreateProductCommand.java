package pl.britenet.campus.obj.productCommands;

import pl.britenet.campus.obj.Command;
import pl.britenet.campus.obj.model.Product;
import pl.britenet.campus.service.ProductService;

import java.util.Scanner;

public class CreateProductCommand extends Command {
    private final ProductService productService;

    public CreateProductCommand(ProductService productService) {
        super("create-product");

        this.productService = productService;
    }

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź ID produktu, który chcesz dodać:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wprowadź nazwę produktu:");
        String name = scanner.nextLine();

        System.out.println("Wprowadź opis produktu:");
        String description = scanner.nextLine();

        System.out.println("Wprowadź cenę produktu:");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Wprowadź id kategorii:");
        int category_id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wprowadź poziom zniżki:");
        int discount_id = scanner.nextInt();

        productService.create(id, name, description, price, discount_id, category_id);
        Product product = productService.retrieve(id).orElseThrow();

        System.out.println("Produkt został utworzony i dodany do listy produktów.");
        System.out.println(product.getName() + " - " + product.getDescription() + " - " + product.getPrice());
    }
}
