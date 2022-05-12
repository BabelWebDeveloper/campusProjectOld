package pl.britenet.campus.obj.cardProductCommands;

import pl.britenet.campus.builder.CardProductBuilder;
import pl.britenet.campus.obj.Command;
import pl.britenet.campus.obj.model.CardProduct;
import pl.britenet.campus.service.CardProductService;

import java.util.Scanner;

public class UpdateCardProductCommand extends Command {
    private final CardProductService cardProductService;

    public UpdateCardProductCommand(CardProductService cardProductService) {
        super("update-cardProduct");

        this.cardProductService = cardProductService;
    }

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź ID cardProduct");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wprowadź card_id:");
        int card_id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wprowadź product_id:");
        int product_id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wprowadź quantity:");
        int quantity = scanner.nextInt();

        CardProduct cardProduct = new CardProductBuilder(id)
                .setCardId(card_id)
                .setProductId(product_id)
                .setQuantity(quantity)
                .getCardProduct();

        cardProductService.update(cardProduct);

        cardProduct = cardProductService.retrieve(id).orElseThrow();

        System.out.println(cardProduct);
    }
}
