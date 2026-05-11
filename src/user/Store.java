package user;
import domain.Menus;
import domain.stock.Stock;
import java.util.Scanner;

public class Store {

    Stock stock = new Stock();
    private static Scanner scanner = new Scanner(System.in);
    private static Menus menus = new Menus();

    private static int choice;

    public static void main(String[] args) {

        mainMenu();
    }

    private static void mainMenu() {
        boolean isRunning = true;
        
        do{
            menus.userMenu();

            switch(choice){

                case 1 : 
                    adminChoice();
                    break;
                case 2 :
                    userChoice();
                    break;
                case 3 :
                    isRunning = false;
            }

        } while(isRunning);
    }

    private static void adminChoice() {

        menus.adminMenu();

        int choice = 0;
        String model;
        String brand;

        switch(choice){

            case 1 :
                stock.addVehicle(choice, modelInput(), brandInput(), Stock.vehicleStock);
                break;
            case 2 :
                stock.removeVehicle(modelInput(), brandInput(), Stock.vehicleStock);
                break;
            case 3 :
                menus.vehicleMenu();

                int subChoice;
                subChoice = scanner.nextInt();
                stock.showVehicles(subChoice, Stock.vehicleStock);
                break;
            case 4 :
                mainMenu();
        } 
    }

}
