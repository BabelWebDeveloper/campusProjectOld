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
                "delete-product -> Usuń produkt\n" +
                "\n" +
                "Komendy kategorii:\n" +
                "create-category -> Stwórz nową kategorie\n" +
                "retrieve-category -> Wybierz kategorie i zobacz ją\n" +
                "update-category -> Zaktualizuj kategorię\n" +
                "delete-category -> Usuń kategorię\n" +
                "\n" +
                "Komendy karty:\n" +
                "create-card -> Stwórz nową kartę\n" +
                "retrieve-card -> Wybierz kartę i zobacz ją\n" +
                "update-card -> Zaktualizuj kartę\n" +
                "delete-card -> Usuń kartę\n" +
                "\n" +
                "Komendy klienta:\n" +
                "create-customer -> Stwórz nowego klienta\n" +
                "retrieve-customer -> Wybierz klienta i zobacz ją\n" +
                "update-customer -> Zaktualizuj klienta\n" +
                "delete-customer -> Usuń klienta\n");
        System.out.println("exit -> exit from app");
        System.out.println("====================");
    }

}
