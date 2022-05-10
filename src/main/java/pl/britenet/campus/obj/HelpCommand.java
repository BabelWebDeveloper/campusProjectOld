package pl.britenet.campus.obj;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("help");
    }

    @Override
    public void perform() {
        System.out.println("====================");
        System.out.println("List of commands:\n" +
                "help -> show all commands\n" +
                "create-product -> create new product\n" +
                "create-category -> create new category\n" +
                "exit -> exit from app");
        System.out.println("====================");
    }

}
