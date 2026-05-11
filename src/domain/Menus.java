package domain;

public final class Menus {

    public static void userMenu() {
        System.out.println("Choose a user:");
        System.out.println("1 ) Admin");
        System.out.println("2 ) Client");    
        System.out.println("3 ) Exit");
    }
    
    public static void adminMenu(){
        System.out.println("Vehicle Rental Admin:");
        System.out.println("1 ) Add vehicle");
        System.out.println("2 ) Remove vehicle");
        System.out.println("3 ) Return");
    }

    public static void mainMenu() {
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
}
