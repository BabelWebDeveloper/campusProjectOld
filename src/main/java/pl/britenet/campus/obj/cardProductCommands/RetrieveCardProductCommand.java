package pl.britenet.campus.obj.cardProductCommands;

import pl.britenet.campus.obj.Command;
import pl.britenet.campus.obj.model.CardProduct;
import pl.britenet.campus.service.CardProductService;

import java.util.Scanner;

public class RetrieveCardProductCommand extends Command {
    private final CardProductService cardProductService;

    public RetrieveCardProductCommand(CardProductService cardProductService) {
        super("retrieve-cardProduct");

        this.cardProductService = cardProductService;
    }

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź ID cardProduct");
        int id = scanner.nextInt();

        cardProductService.display(id);
        CardProduct cardProduct = cardProductService.retrieve(id).orElseThrow();
    }
}
