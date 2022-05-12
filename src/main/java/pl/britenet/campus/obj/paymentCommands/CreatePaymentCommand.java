package pl.britenet.campus.obj.paymentCommands;

import pl.britenet.campus.builder.PaymentBuilder;
import pl.britenet.campus.builder.ProductBuilder;
import pl.britenet.campus.obj.Command;
import pl.britenet.campus.obj.model.Payment;
import pl.britenet.campus.obj.model.Product;
import pl.britenet.campus.service.PaymentService;
import pl.britenet.campus.service.ProductService;

import java.util.Scanner;

public class CreatePaymentCommand extends Command {
    private final PaymentService paymentService;

    public CreatePaymentCommand(PaymentService paymentService) {
        super("create-payment");

        this.paymentService = paymentService;
    }

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź ID płatności, który chcesz dodać:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wprowadź customer_id:");
        int customer_id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wprowadź date");
        int date = scanner.nextInt();

        Payment payment = new PaymentBuilder(id)
                .setCustomerId(customer_id)
                .setDate(date)
                .getPayment();

        paymentService.create(payment);

        payment = paymentService.retrieve(id).orElseThrow();

        System.out.println(payment);
    }
}
