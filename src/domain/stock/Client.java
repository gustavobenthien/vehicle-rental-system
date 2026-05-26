package domain.stock;
import domain.console.Input;
import domain.vehicles.Car;
import domain.vehicles.Motorcycle;
import domain.vehicles.Truck;
import domain.vehicles.Vehicle;
import java.util.ArrayList;
import java.util.Scanner;
import domain.console.Console;

public class Client implements RentalService {
    
    public static final ArrayList<Vehicle> rents = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public float calculateFee(float pricing, int hours) {
        return pricing * hours;              
    }    

    public void receipt(String model, String brand, float pricing, ArrayList<Vehicle> list) {
        
        Vehicle newRent = searchVehicle(model, brand, Client.rents);

        Console.clearConsole();
        System.out.println("\nRented: ");
        System.out.println("=====================");
        System.out.println(newRent.getModel() + '-' + newRent.getBrand());
        System.out.println("Total value: " + newRent.getTotalValue());
        System.out.println("=====================");
        System.out.print("(Press enter) >: ");
        scanner.nextLine();
    }
    
    @Override
    public void addVehicle(int type, String model, String brand, float pricing, ArrayList<Vehicle> list) {

        while(true){
            
            try{

                int hours = Input.hour();
                Vehicle newVehicle;

                switch(type) {
                    case 1 :
                        newVehicle = new Truck(model, brand, pricing);
                        newVehicle.setTotalValue(calculateFee(pricing, hours));
                        rents.add(newVehicle);

                        receipt(model, brand, pricing, Client.rents);
                        return;
                    case 2 :
                        newVehicle = new Car(model, brand, pricing);
                        newVehicle.setTotalValue(calculateFee(pricing, hours));
                        rents.add(newVehicle);

                        receipt(model, brand, pricing, Client.rents);
                        return;
                    case 3 :
                        newVehicle = new Motorcycle(model, brand, pricing);
                        newVehicle.setTotalValue(calculateFee(pricing, hours));
                        rents.add(newVehicle);

                        receipt(model, brand, pricing, Client.rents);
                        return;
                    case 4 :
                        return;
                    default :
                        throw new IllegalArgumentException();
                }

            } catch(IllegalArgumentException e) {
                Console.clearConsole();
                System.out.println("Invalid value! Try again.");
                System.out.println("(Press enter) >: ");
                scanner.nextLine();
            }
        }
    }

    @Override
    public void removeVehicle(String model, String brand, ArrayList<Vehicle> list) {

        for(int i = 0; i < list.size(); i++) {
            Vehicle v = list.get(i);

            if(v.getModel().equalsIgnoreCase(model) && v.getBrand().equalsIgnoreCase(brand)) {
                list.remove(i);
                return;
            }    
        }
        
        Console.clearConsole();
        System.out.println("Vehicle not found!");
        System.out.print("(Press enter) >: ");
        scanner.nextLine();
    }

    @Override
    public boolean showVehicles(int type, ArrayList<Vehicle> list) {

        try{

            boolean isInstance = false;

            for(Vehicle v : list) {

                switch(type) {

                    case 1 : 
                        if(v instanceof Truck) {
                            System.out.println("=====================");
                            System.out.print(v.getModel() + "-");
                            System.out.print(v.getBrand());
                            System.out.print(" (" + v.getTotalValue() + " R$)\n");
                            isInstance = true;
                        }
                        break;
                    case 2 :
                        if(v instanceof Car) {
                            System.out.println("=====================");
                            System.out.print(v.getModel() + "-");
                            System.out.print(v.getBrand());
                            System.out.print(" (" + v.getTotalValue() + " R$)\n");
                            isInstance = true;
                        }      
                        break;
                    case 3 :
                        if(v instanceof Motorcycle) {
                            System.out.println("=====================");
                            System.out.print(v.getModel() + "-");
                            System.out.print(v.getBrand());
                            System.out.print(" (" + v.getTotalValue() + " R$)\n");
                            isInstance = true;
                        } 
                        break;
                    case 4 :
                        return false;
                    default :
                        throw new IllegalArgumentException();
                }
            }

            if(!isInstance) {
                return false;
            }

            System.out.println("=====================");
            System.out.print("(Press enter) >: ");
            scanner.nextLine();

        } catch(IllegalArgumentException e) {
            Console.clearConsole();
            System.out.println("Invalid value! Try again.");
            System.out.println("(Press enter) >: ");
            scanner.nextLine();
            return false;
        }

        return true;
    }

    @Override
    public Vehicle searchVehicle(String model, String brand, ArrayList<Vehicle> list) {
        
        for(int i = 0; i < list.size(); i++) {
            Vehicle v = list.get(i);

            if(v.getModel().equalsIgnoreCase(model) && v.getBrand().equalsIgnoreCase(brand)) {
                Vehicle vehicle = new Vehicle(v.getModel(), v.getBrand(), v.getPricing());
                vehicle.setTotalValue(v.getTotalValue());
                return vehicle;
            }    
        }

        Console.clearConsole();
        System.out.println("Vehicle not found!");
        System.out.print("(Press enter) >: ");
        scanner.nextLine();
        
        return null;
    }
}