package pl.britenet.campus.obj.cardCommands;

import pl.britenet.campus.builder.CardBuilder;
import pl.britenet.campus.obj.Command;
import pl.britenet.campus.obj.model.Card;
import pl.britenet.campus.service.CardService;
import pl.britenet.campus.service.CategoryService;

import java.util.Scanner;

public class UpdateCardCommand extends Command {
    private final CardService cardService;

    public UpdateCardCommand(CardService cardService) {
        super("update-card");

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

        System.out.println("Wprowadź isOrdered: y/n");
        String isOrderedString = scanner.nextLine();
        boolean isOrdered;
        if (isOrderedString.equals("y")){
            isOrdered = true;
        } else if (isOrderedString.equals("n")){
            isOrdered = false;
        } else {
            System.out.println("Wrong command! isOrderd set as false");
            isOrdered = false;
        }

        System.out.println("Wprowadź payment_id:");
        int payment_id = scanner.nextInt();

        Card card = new CardBuilder(id)
                .setCustomerId(customer_id)
                .setPaymentId(payment_id)
                .setTotalCost(total_cost)
                .setOrdered(isOrdered)
                .getCard();

        cardService.update(card);

        System.out.println(card);
    }
}
