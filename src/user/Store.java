package user;
import domain.Console;
import domain.stock.Stock;

public class Store {

    Stock stock = new Stock();
    private static Console console = new Console();
    private static int choice;

    public static void main(String[] args) {
        console.handleMainMenu();
    }
}
