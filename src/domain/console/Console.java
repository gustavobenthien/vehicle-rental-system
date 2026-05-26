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

            clearConsole();
            
            try{

                Menu.mainMenu();
            
                switch(Input.choice(3)){
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
                clearConsole();
                System.out.println("Invalid value! Try again.");
                System.out.println("(Press enter) >: ");
                scanner.nextLine();
            }
        }
    }

    public static void adminMenu() {

        while(true){

            clearConsole();
        
            try{

                Menu.adminMenu();

                int subChoice;

                switch(Input.choice(4)){
                    case 1 :
                        clearConsole();
                        Menu.vehicleMenu();

                        subChoice = Input.choice(4);

                        if(subChoice == 4) {
                            clearConsole();
                            adminMenu();
                        }
                        
                        admin.addVehicle(subChoice, Input.model(), Input.brand(), Input.pricing(), Admin.stock);
                        
                        clearConsole();
                        adminMenu();
                        break;
                    case 2 :
                        clearConsole();
                        Menu.vehicleMenu();

                        subChoice = Input.choice(4);

                        if(!admin.showVehicles(subChoice, Admin.stock)){
                            clearConsole();
                            if(subChoice != 4) {
                                System.out.println("No vehicles to remove at the moment.");
                                System.out.print("(Press enter) >: ");
                                scanner.nextLine();
                            }
                            break;
                        }

                        admin.removeVehicle(Input.model(), Input.brand(), Admin.stock);

                        clearConsole();
                        adminMenu();
                        break;
                    case 3 :
                        clearConsole();
                        Menu.vehicleMenu();

                        subChoice = Input.choice(4);

                        if(!admin.showVehicles(subChoice, Admin.stock)){
                            clearConsole();
                            if(subChoice != 4) {
                                System.out.println("No vehicles at the stock.");
                                System.out.print("(Press enter) >: ");
                                scanner.nextLine();
                            }
                            break;
                        }
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
                clearConsole();
                System.out.println("Invalid value! Try again.");
                System.out.println("(Press enter) >: ");
                scanner.nextLine();
            }
        }
    }

    public static void clientMenu() {

        while(true){
            
            clearConsole();
            
            try{

                Menu.clientMenu();

                int choice = Input.choice(4);
                int subChoice;
                Vehicle v;

                switch(choice) {
                    case 1 :
                        clearConsole();
                        Menu.vehicleMenu();
                        
                        subChoice = Input.choice(4);

                        if(!admin.showVehicles(subChoice, Admin.stock)){
                            clearConsole();
                            if(subChoice != 4) {
                                System.out.println("No vehicles to rent at the moment.");
                                System.out.print("(Press enter) >: ");
                                scanner.nextLine();
                            }
                            break;
                        }   
                        
                        v = admin.searchVehicle(Input.model(), Input.brand(), Admin.stock);
    
                        client.addVehicle(subChoice, v.getModel(), v.getBrand(), v.getPricing(), Client.rents);
                        admin.removeVehicle(v.getModel(), v.getBrand(), Admin.stock);
                        
                        clearConsole();
                        clientMenu();
                        break;
                    case 2 :
                        clearConsole();
                        Menu.vehicleMenu();

                        subChoice = Input.choice(4);

                        if(!client.showVehicles(subChoice, Client.rents)){
                            clearConsole();
                            if(subChoice != 4) {
                                System.out.println("No vehicles rented at the moment.");
                                System.out.print("(Press enter) >: ");
                                scanner.nextLine();
                            }
                            break;
                        }
                        
                        v = client.searchVehicle(Input.model(), Input.brand(), Client.rents);
    
                        if(v == null) {
                            break;
                        } 
                        else {
                            admin.addVehicle(subChoice, v.getModel(), v.getBrand(), v.getPricing(), Admin.stock);
                            client.removeVehicle(v.getModel(), v.getBrand(), Client.rents);
                        }

                        clearConsole();
                        clientMenu();
                        break;
                    case 3 :
                        clearConsole();
                        Menu.vehicleMenu();

                        subChoice = Integer.parseInt(scanner.nextLine());

                        if(!client.showVehicles(subChoice, Client.rents)){
                            clearConsole();
                            if(subChoice != 4) {
                                System.out.println("No vehicles rented at the moment.");
                                System.out.print("(Press enter) >: ");
                                scanner.nextLine();
                            }
                            break;
                        }
                        
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
                clearConsole();
                System.out.println("Invalid value! Try again.");
                System.out.println("(Press enter) >: ");
                scanner.nextLine();
            }
        } 
    }
}