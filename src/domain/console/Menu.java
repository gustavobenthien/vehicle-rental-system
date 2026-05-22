package domain.console;

public abstract class Menu {
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
}
