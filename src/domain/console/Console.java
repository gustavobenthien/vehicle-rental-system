package domain.console;
import domain.stock.Admin;
import domain.stock.Client;
import domain.vehicles.Vehicle;
import java.util.Scanner;

public final class Console {

    // FIX: CONSOLE WITH NEW REFACTOR    

    private static final Admin admin = new Admin();
    private static final Client client = new Client();
    private static final Scanner scanner = new Scanner(System.in);

   
    public static void mainMenu() {

        while(true) {
            
            try{
                Menu.mainMenu();
            
                int choice = Integer.parseInt(scanner.nextLine());
            
                switch(choice){
                    case 1 : 
                        adminMenu();
                        break;
                    case 2 :
                        clientMenu();
                        break;
                    case 3 :
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
                        Menu.vehicleMenu();

                        subChoice = Integer.parseInt(scanner.nextLine());

                        admin.addVehicle(subChoice, Input.model(), Input.brand(), Admin.stock);
                        adminMenu();
                        break;
                    case 2 :
                        Menu.vehicleMenu();

                        subChoice = Integer.parseInt(scanner.nextLine());

                        admin.showVehicles(subChoice, Admin.stock);
                        admin.removeVehicle(Input.model(), Input.brand(), Admin.stock);
                        adminMenu();
                        break;
                    case 3 :
                        Menu.vehicleMenu();

                        subChoice = Integer.parseInt(scanner.nextLine());

                        admin.showVehicles(subChoice, Admin.stock);
                        adminMenu();
                        break;
                    case 4 :
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

        Menu.clientMenu();

        int choice = Integer.parseInt(scanner.nextLine());
        int subChoice;
        Vehicle rentedVehicle;

        switch(choice) {
            case 1 :
                
                break;
            case 2 :
                
                break;
            case 3 :
                
                break;
            case 4 :
                
                break;
            default :
                throw new IllegalArgumentException();
        }
    }
}

