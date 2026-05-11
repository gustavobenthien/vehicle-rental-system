package domain;
import java.util.Scanner;

public final class Console {

    private static final Scanner scanner = new Scanner(System.in);

    // Console aesthetic

    public static void mainMenu() {
        System.out.println("Choose a user:");
        System.out.println("1 ) Admin");
        System.out.println("2 ) Client");    
        System.out.println("3 ) Exit");
    }
    
    public static void adminMenu(){
        System.out.println("Vehicle Rental Admin:");
        System.out.println("1 ) Add vehicle");
        System.out.println("2 ) Remove vehicle");
        System.out.println("3 ) Show vehicles");
        System.out.println("4 ) Return");
    }

    public static void clientMenu() {
        System.out.println("Vehicle Rental Store:");
        System.out.println("1 ) Rent vehicle");
        System.out.println("2 ) Cancel rent");
        System.out.println("3 ) Status");
        System.out.println("4 ) Return");
    }

    public static void vehicleMenu() {
        System.out.println("Choose a vehicle:");
        System.out.println("1 ) Trucks");
        System.out.println("2 ) Cars");
        System.out.println("3 ) Motorcycles");
        System.out.println("4 ) Return");
    }

    // Program logic

    private static String modelInput() {
        String model;

        System.out.print("Vehicle model: ");
        model = scanner.nextLine();

        return model;
    }

    private static String brandInput() {
        String brand;

        System.out.print("Vehicle brand: ");
        brand = scanner.nextLine();

        return brand;
    }

    private static void handleMainMenu() {

        boolean isRunning = true;
        int choice;

        
        do{
            mainMenu();

            choice = scanner.nextInt();

            switch(choice){

                case 1 : 
                    //handleAdminMenu();
                    break;
                case 2 :
                    //handleUserMenu();
                    break;
                case 3 :
                    isRunning = false;
            }

        } while(isRunning);
    }
}
