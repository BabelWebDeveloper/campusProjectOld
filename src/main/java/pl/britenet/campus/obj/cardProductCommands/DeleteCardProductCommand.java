package pl.britenet.campus.obj.cardProductCommands;

import pl.britenet.campus.obj.Command;
import pl.britenet.campus.obj.model.CardProduct;
import pl.britenet.campus.service.CardProductService;

import java.util.Scanner;

public class DeleteCardProductCommand extends Command {
    private final CardProductService cardProductService;

    public DeleteCardProductCommand(CardProductService cardProductService) {
        super("delete-cardProduct");

        this.cardProductService = cardProductService;
    }

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź ID cardProduct");
        int id = scanner.nextInt();
        scanner.nextLine();

        cardProductService.remove(id);

        System.out.println("Karta została usunięta.");
    }
}
