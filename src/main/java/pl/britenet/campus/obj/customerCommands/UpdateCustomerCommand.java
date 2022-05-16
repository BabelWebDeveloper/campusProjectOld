package pl.britenet.campus.obj.customerCommands;

import pl.britenet.campus.builder.CustomerBuilder;
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

        Customer customer = new CustomerBuilder(id)
                .setFirstName(first_name)
                .setLastName(last_name)
                .setPhone(phone)
                .setEmail(email)
                .setStreet(street)
                .setCity(city)
                .setZipCode(zip_code)
                .getCustomer();

        customerService.update(customer);
        System.out.println("Klient został zaktualizowany");
        System.out.println(customer);
    }
}
