package pl.britenet.campus.obj.cardCommands;

import pl.britenet.campus.obj.Command;
import pl.britenet.campus.service.CardService;
import pl.britenet.campus.service.CategoryService;

import java.util.Scanner;

public class DeleteCardCommand extends Command {
    private final CardService cardService;

    public DeleteCardCommand(CardService cardService) {
        super("delete-card");

        this.cardService = cardService;
    }

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź ID pkarty, którą chcesz usunąć:");
        int id = scanner.nextInt();

        cardService.remove(id);

        System.out.println("Karta została usunięta.");
    }
}
