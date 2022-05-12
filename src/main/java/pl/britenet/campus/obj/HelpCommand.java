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
                "Komendy produktu:\n" +
                "create-product -> Stwórz nowy produkt\n" +
                "retrieve-product -> Wybierz produkt i zobacz go\n" +
                "update-product -> Zaktualizuj produkt\n" +
                "delete-product -> Usuń produkt\n");
        System.out.println("exit -> exit from app");
        System.out.println("====================");
    }

}
