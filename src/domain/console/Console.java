package domain.console;
import domain.stock.Admin;
import domain.stock.Client;
import domain.vehicles.Vehicle;
import java.util.Scanner;

public final class Console {

    private static final Admin admin = new Admin();
    private static final Client client = new Client();
    private static final Scanner scanner = new Scanner(System.in);

    public static void clearConsole(){
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }
   
    public static void mainMenu() {

        while(true) {
            
            try{
                Menu.mainMenu();
            
                int choice = Integer.parseInt(scanner.nextLine());
            
                switch(choice){
                    case 1 : 
                        clearConsole();
                        adminMenu();
                        break;
                    case 2 :
                        clearConsole();
                        clientMenu();
                        break;
                    case 3 :
                        clearConsole();
                        System.exit(0);
                    default :
                        throw new IllegalArgumentException();
                }
            } catch(IllegalArgumentException e) {
                System.out.println("Invalid value! Try again.");
            }
        }
    }

    public static void adminMenu() {

        while(true){
        
            try{
                Menu.adminMenu();

                int choice = Integer.parseInt(scanner.nextLine());
                int subChoice;

                switch(choice){
                    case 1 :
                        clearConsole();
                        Menu.vehicleMenu();

                        subChoice = Integer.parseInt(scanner.nextLine());

                        admin.addVehicle(subChoice, Input.model(), Input.brand(), Input.pricing(), Admin.stock);
                        
                        clearConsole();
                        adminMenu();
                        break;
                    case 2 :
                        clearConsole();
                        Menu.vehicleMenu();

                        subChoice = Integer.parseInt(scanner.nextLine());

                        admin.showVehicles(subChoice, Admin.stock);
                        admin.removeVehicle(Input.model(), Input.brand(), Admin.stock);

                        clearConsole();
                        adminMenu();
                        break;
                    case 3 :
                        clearConsole();
                        Menu.vehicleMenu();

                        subChoice = Integer.parseInt(scanner.nextLine());

                        admin.showVehicles(subChoice, Admin.stock);
                        
                        clearConsole();
                        adminMenu();
                        break;
                    case 4 :
                        clearConsole();
                        mainMenu();
                        break;
                    default :
                        throw new IllegalArgumentException();
                } 
            } catch(IllegalArgumentException e) {
                System.out.println("Invalid value! Try again");
            }
        }
    }

    public static void clientMenu() {

        while(true){

            try{
                Menu.clientMenu();

                int choice = Integer.parseInt(scanner.nextLine());
                int subChoice;

                Vehicle v;

                switch(choice) {
                    case 1 :
                        clearConsole();
                        Menu.vehicleMenu();

                        subChoice = Integer.parseInt(scanner.nextLine());
                        admin.showVehicles(subChoice, Admin.stock);

                        v = admin.searchVehicle(Input.model(), Input.brand(), Admin.stock);

                        client.addVehicle(subChoice, v.getModel(), v.getBrand(), v.getPricing(), Client.rents);
                        admin.removeVehicle(v.getModel(), v.getBrand(), Admin.stock);

                        clearConsole();
                        clientMenu();
                        break;
                    case 2 :
                        clearConsole();
                        Menu.vehicleMenu();

                        subChoice = Integer.parseInt(scanner.nextLine());
                        
                        v = admin.searchVehicle(Input.model(), Input.brand(), Admin.stock);

                        client.removeVehicle(v.getModel(), v.getBrand(), Client.rents);
                        admin.addVehicle(subChoice, v.getModel(), v.getBrand(), v.getPricing(), Admin.stock);

                        clearConsole();
                        clientMenu();
                        break;
                    case 3 :
                        clearConsole();
                        Menu.vehicleMenu();

                        subChoice = Integer.parseInt(scanner.nextLine());

                        System.out.println("Your vehicles: ");
                        client.showVehicles(subChoice, Client.rents);
                        
                        clearConsole();
                        clientMenu();
                        break;
                    case 4 :
                        clearConsole();
                        mainMenu();
                        break;
                    default :
                        throw new IllegalArgumentException();
                }
            } catch(IllegalArgumentException e) {
            System.out.println("Invalid value! Try again.");
            }
        } 
    }
}

