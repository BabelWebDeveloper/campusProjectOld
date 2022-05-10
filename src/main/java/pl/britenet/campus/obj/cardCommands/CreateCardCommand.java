package pl.britenet.campus.obj.cardCommands;

import pl.britenet.campus.obj.Command;
import pl.britenet.campus.obj.model.Card;
import pl.britenet.campus.service.CardService;
import pl.britenet.campus.service.CategoryService;

import java.util.Scanner;

public class CreateCardCommand extends Command {
    private final CardService cardService;

    public CreateCardCommand(CardService cardService) {
        super("create-card");

        this.cardService = cardService;
    }

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź ID karty:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wprowadź customer_id:");
        int customer_id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wprowadź total_cost:");
        double total_cost = scanner.nextDouble();
        scanner.nextLine();

        cardService.create(id, customer_id, total_cost);
        Card card = cardService.retrieve(id).orElseThrow();

        System.out.println("Karta została stworzona.");
    }
}
