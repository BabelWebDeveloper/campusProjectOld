package pl.britenet.campus.obj.paymentCommands;

import pl.britenet.campus.builder.PaymentBuilder;
import pl.britenet.campus.obj.Command;
import pl.britenet.campus.obj.model.Payment;
import pl.britenet.campus.service.PaymentService;

import java.util.Scanner;
public class UpdatePaymentCommand extends Command {
    private final PaymentService paymentService;
    public UpdatePaymentCommand(PaymentService paymentService) {
        super("update-payment");

        this.paymentService = paymentService;
    }

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź ID płatności, który chcesz zaktualizowac:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wprowadź customer_id:");
        int customer_id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wprowadź date");
        String date = scanner.nextLine();

        Payment payment = new PaymentBuilder(id)
                .setCustomerId(customer_id)
                .setDate(date)
                .getPayment();

        paymentService.update(payment);

        System.out.println(payment);
    }
}
