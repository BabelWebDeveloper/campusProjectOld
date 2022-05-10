package pl.britenet.campus;

import pl.britenet.campus.obj.*;
import pl.britenet.campus.service.CommandService;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//        ==================================================
        CommandService commandService = new CommandService();

        HelpCommand helpCommand = new HelpCommand();
        ExitCommand exitCommand = new ExitCommand();
        CreateProductCommand createProductCommand = new CreateProductCommand();

        commandService.registerCommand(helpCommand);
        commandService.registerCommand(exitCommand);
        commandService.registerCommand(createProductCommand);

        System.out.println("Welcome to console menu!");
        if (commandService.getCommand("help").isPresent()) {
            commandService.getCommand("help").get().perform();
        }
        else {
            System.out.println("Nieznana komenda.");
        }

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
