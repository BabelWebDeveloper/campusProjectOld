package pl.britenet.campus.obj.customerCommands;

import pl.britenet.campus.obj.Command;
import pl.britenet.campus.obj.model.Customer;
import pl.britenet.campus.service.CardService;
import pl.britenet.campus.service.CustomerService;

import java.util.Scanner;

public class UpdateCustomerCommand extends Command {
    private final CustomerService customerService;

    public UpdateCustomerCommand(CustomerService customerService) {
        super("update-customer");

        this.customerService = customerService;
    }

    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź ID klienta:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wprowadź imię:");
        String first_name = scanner.nextLine();

        System.out.println("Wprowadź nazwisko:");
        String last_name = scanner.nextLine();

        System.out.println("Wprowadź telefon:");
        String phone = scanner.nextLine();

        System.out.println("Wprowadź email:");
        String email = scanner.nextLine();

        System.out.println("Wprowadź ulicę:");
        String street = scanner.nextLine();

        System.out.println("Wprowadź miasto:");
        String city = scanner.nextLine();

        System.out.println("Wprowadź kod pocztowy:");
        int zip_code = scanner.nextInt();

        customerService.update(id,first_name,last_name,phone,email,street,city,zip_code);
        Customer customer = customerService.retrieve(id).orElseThrow();

        System.out.println("Klient został zaktualizwoany.");
    }
}
