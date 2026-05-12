package domain;
import domain.stock.Stock;
import java.util.Scanner;

public final class Console {

    private static final Stock stock = new Stock();
    private static final Scanner scanner = new Scanner(System.in);

    // Console aesthetic

    public static void mainMenu() {
        System.out.println("\nChoose a user:");
        System.out.println("1 ) Admin");
        System.out.println("2 ) Client");    
        System.out.println("3 ) Exit");
        System.out.print(">: ");
    }
    
    public static void adminMenu(){
        System.out.println("\nVehicle Rental Admin:");
        System.out.println("1 ) Add vehicle");
        System.out.println("2 ) Remove vehicle");
        System.out.println("3 ) Show vehicles");
        System.out.println("4 ) Return");
        System.out.print(">: ");
    }

    public static void clientMenu() {
        System.out.println("\nVehicle Rental Store:");
        System.out.println("1 ) Rent vehicle");
        System.out.println("2 ) Cancel rent");
        System.out.println("3 ) Status");
        System.out.println("4 ) Return");
        System.out.print(">: ");
    }

    public static void vehicleMenu() {
        System.out.println("\nChoose a vehicle type:");
        System.out.println("1 ) Trucks");
        System.out.println("2 ) Cars");
        System.out.println("3 ) Motorcycles");
        System.out.println("4 ) Return");
        System.out.print(">: ");
    }

    // Program logic

    public static String modelInput() {
        String model;

        System.out.print("Vehicle model: ");
        model = scanner.nextLine();

        return model;
    }

    public static String brandInput() {
        String brand;

        System.out.print("Vehicle brand: ");
        brand = scanner.nextLine();

        return brand;
    }

    public static int hourInput() {
        int hours;

        System.out.print("Rent hours: ");
        hours = Integer.parseInt(scanner.nextLine());

        return hours;
    }

    public static void handleMainMenu() {

        while(true) {
            mainMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch(choice){
                case 1 : 
                    handleAdminMenu();
                    break;
                case 2 :
                    handleClientMenu();
                    break;
                case 3 :
                    System.exit(0);
                default :
                    throw new IllegalArgumentException("Invalid value!");
            }
        }
    }

    public static void handleAdminMenu() {
        
        adminMenu();
        int choice = Integer.parseInt(scanner.nextLine());
        int subChoice;

        switch(choice){

            case 1 :
                vehicleMenu();
                subChoice = Integer.parseInt(scanner.nextLine());
                stock.addVehicle(subChoice, modelInput(), brandInput(), Stock.vehicleStock);
                handleAdminMenu();
                break;
            case 2 :
                vehicleMenu();
                subChoice = Integer.parseInt(scanner.nextLine());
                System.out.println("Cars available: ");
                stock.showVehicles(subChoice, Stock.vehicleStock);
                stock.removeVehicle(modelInput(), brandInput(), Stock.vehicleStock);
                handleAdminMenu();
                break;
            case 3 :
                vehicleMenu();
                subChoice = Integer.parseInt(scanner.nextLine());
                stock.showVehicles(subChoice, Stock.vehicleStock);
                handleAdminMenu();
                break;
            case 4 :
                handleMainMenu();
                break;
            default :
                throw new IllegalArgumentException("Invalid value");
        } 
    }

    public static void handleClientMenu() {

        clientMenu();
        int choice = Integer.parseInt(scanner.nextLine());
        int subChoice;

        switch(choice) {

            case 1 :
                vehicleMenu();
                subChoice = Integer.parseInt(scanner.nextLine());
                stock.showVehicles(subChoice, Stock.vehicleStock);
                stock.rentVehicle(subChoice, modelInput(), brandInput(), hourInput());
                System.out.println("total amount: " + Stock.totalValue);
                break;
            case 2 :
                vehicleMenu();
                subChoice = Integer.parseInt(scanner.nextLine());
                stock.cancelRent(subChoice, modelInput(), brandInput());
                break;
            case 3 :
                vehicleMenu();
                subChoice = Integer.parseInt(scanner.nextLine());
                stock.showVehicles(subChoice, Stock.userRents);
                break;
            case 4 :
                handleMainMenu();
                break;
            default :
                throw new IllegalArgumentException("Invalid value!");
        }
    }
}

