package pl.britenet.campus;

import pl.britenet.campus.obj.*;
import pl.britenet.campus.obj.cardCommands.CreateCardCommand;
import pl.britenet.campus.obj.cardCommands.DeleteCardCommand;
import pl.britenet.campus.obj.cardCommands.RetrieveCardCommand;
import pl.britenet.campus.obj.cardCommands.UpdateCardCommand;

import pl.britenet.campus.obj.cardProductCommands.CreateCardProductCommand;
import pl.britenet.campus.obj.cardProductCommands.DeleteCardProductCommand;
import pl.britenet.campus.obj.cardProductCommands.RetrieveCardProductCommand;
import pl.britenet.campus.obj.cardProductCommands.UpdateCardProductCommand;
import pl.britenet.campus.obj.categoryCommands.CreateCategoryCommand;
import pl.britenet.campus.obj.categoryCommands.DeleteCategoryCommand;
import pl.britenet.campus.obj.categoryCommands.RetrieveCategoryCommand;
import pl.britenet.campus.obj.categoryCommands.UpdateCategoryCommand;

import pl.britenet.campus.obj.customerCommands.CreateCustomerCommand;
import pl.britenet.campus.obj.customerCommands.DeleteCustomerCommand;
import pl.britenet.campus.obj.customerCommands.RetrieveCustomerCommand;
import pl.britenet.campus.obj.customerCommands.UpdateCustomerCommand;

import pl.britenet.campus.obj.discountCommands.CreateDiscountCommand;
import pl.britenet.campus.obj.discountCommands.DeleteDiscountCommand;
import pl.britenet.campus.obj.discountCommands.RetrieveDiscountCommand;
import pl.britenet.campus.obj.discountCommands.UpdateDiscountCommand;
import pl.britenet.campus.obj.paymentCommands.CreatePaymentCommand;
import pl.britenet.campus.obj.paymentCommands.DeletePaymentCommand;
import pl.britenet.campus.obj.paymentCommands.RetrievePaymentCommand;
import pl.britenet.campus.obj.paymentCommands.UpdatePaymentCommand;
import pl.britenet.campus.obj.productCommands.CreateProductCommand;
import pl.britenet.campus.obj.productCommands.DeleteProductCommand;
import pl.britenet.campus.obj.productCommands.RetrieveProductCommand;
import pl.britenet.campus.obj.productCommands.UpdateProductCommand;
import pl.britenet.campus.service.*;
import pl.britenet.campus.service.database.DatabaseService;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService();
        CategoryService categoryService = new CategoryService();
        CardService cardService = new CardService();
        CardProductService cardProductService = new CardProductService();
        CustomerService customerService = new CustomerService();
        PaymentService paymentService = new PaymentService();
        DiscountService discountService = new DiscountService();

        CommandService commandService = new CommandService();

        HelpCommand helpCommand = new HelpCommand();
        ExitCommand exitCommand = new ExitCommand();

        commandService.registerCommand(helpCommand);
        commandService.registerCommand(exitCommand);

        commandService.registerCommand(new CreateProductCommand(productService));
        commandService.registerCommand(new RetrieveProductCommand(productService));
        commandService.registerCommand(new UpdateProductCommand(productService));
        commandService.registerCommand(new DeleteProductCommand(productService));

        commandService.registerCommand(new CreateCategoryCommand(categoryService));
        commandService.registerCommand(new RetrieveCategoryCommand(categoryService));
        commandService.registerCommand(new UpdateCategoryCommand(categoryService));
        commandService.registerCommand(new DeleteCategoryCommand(categoryService));

        commandService.registerCommand(new CreateCardCommand(cardService));
        commandService.registerCommand(new RetrieveCardCommand(cardService));
        commandService.registerCommand(new UpdateCardCommand(cardService));
        commandService.registerCommand(new DeleteCardCommand(cardService));

        commandService.registerCommand(new CreateCardProductCommand(cardProductService));
        commandService.registerCommand(new RetrieveCardProductCommand(cardProductService));
        commandService.registerCommand(new UpdateCardProductCommand(cardProductService));
        commandService.registerCommand(new DeleteCardProductCommand(cardProductService));

        commandService.registerCommand(new CreateCustomerCommand(customerService));
        commandService.registerCommand(new RetrieveCustomerCommand(customerService));
        commandService.registerCommand(new UpdateCustomerCommand(customerService));
        commandService.registerCommand(new DeleteCustomerCommand(customerService));

        commandService.registerCommand(new CreatePaymentCommand(paymentService));
        commandService.registerCommand(new RetrievePaymentCommand(paymentService));
        commandService.registerCommand(new UpdatePaymentCommand(paymentService));
        commandService.registerCommand(new DeletePaymentCommand(paymentService));

        commandService.registerCommand(new CreateDiscountCommand(discountService));
        commandService.registerCommand(new RetrieveDiscountCommand(discountService));
        commandService.registerCommand(new UpdateDiscountCommand(discountService));
        commandService.registerCommand(new DeleteDiscountCommand(discountService));

        databaseService.performDML("");

        System.out.println("Witamy w sklepie internetowym!");
        commandService.getCommand("help").get().perform();

        boolean isRunning = true;

        while (isRunning){
            String userCommand = scanner.nextLine();
            Optional<Command> oCommand = commandService.getCommand(userCommand);

            if (userCommand.equals("exit")){
                isRunning = false;
            }

            if (oCommand.isPresent()) {
                oCommand.get().perform();
            }
            else {
                System.out.println("Nieznana komenda.");
            }
        }

    }

}
