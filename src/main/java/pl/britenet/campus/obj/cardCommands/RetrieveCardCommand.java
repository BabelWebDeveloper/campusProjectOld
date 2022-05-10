package pl.britenet.campus.obj.cardCommands;

import pl.britenet.campus.obj.Command;
import pl.britenet.campus.service.CardService;
import pl.britenet.campus.service.CategoryService;

import java.util.Scanner;

public class RetrieveCardCommand extends Command {
    private final CardService cardService;

    public RetrieveCardCommand(CardService cardService) {
        super("retrieve-card");

        this.cardService = cardService;
    }

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź ID karty, którą chcesz wyświetlić.");
        int id = scanner.nextInt();

        cardService.display(id);
    }
}
