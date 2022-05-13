package pl.britenet.campus.obj;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("help");
    }

    @Override
    public void perform() {
        System.out.println("====================");
        System.out.println("Lista dostępnych komend:\n" +
                "help -> Menu\n" +
                "\n" +
                "create- -> Stwórz nowy\n" +
                "retrieve- -> Wybierz i wyświetl \n" +
                "update- -> Zaktualizuj\n" +
                "delete- -> Usuń\n");
        System.out.println("exit -> exit from app");
        System.out.println("====================");
    }

}
