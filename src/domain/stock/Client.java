package domain.stock;
import domain.console.Input;
import domain.vehicles.Car;
import domain.vehicles.Motorcycle;
import domain.vehicles.Truck;
import domain.vehicles.Vehicle;
import java.util.ArrayList;
import java.util.Scanner;

public class Client implements RentalService {
    
    public static final ArrayList<Vehicle> rents = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public float calculateFee(float pricing, int hours) {
        return pricing * hours;              
    }    

    public void receipt(String model, String brand, float pricing, ArrayList<Vehicle> list) {
        
        Vehicle newRent = searchVehicle(model, brand, Client.rents);

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
                    default :
                        throw new IllegalArgumentException();
                }
            } catch(IllegalArgumentException e) {
                System.out.println("Invalid value! Try again");
            }
        }
    }

    @Override
    public void removeVehicle(String model, String brand, ArrayList<Vehicle> list) {

        for(int i = 0; i < list.size(); i++) {
            Vehicle v = list.get(i);

            if(v.getModel().equalsIgnoreCase(model) && v.getBrand().equalsIgnoreCase(brand)) {
                list.remove(i);
                Admin.stock.add(v);
                return;
            }
        }

        System.out.println("Vehicle not rented!");
    }

    @Override
    public void showVehicles(int type, ArrayList<Vehicle> list) {

        if(list.isEmpty()) {
            System.out.println("No vehicles rented at the moment.");
            return;
        }

        System.out.println("\n=====================");

        for(Vehicle v : list) {

            switch(type) {

                case 1 : 
                    if(v instanceof Truck) {
                        System.out.print(v.getModel() + "-");
                        System.out.print(v.getBrand());
                        System.out.print('(' + v.getTotalValue() + " R$)");
                    }
                    break;
                case 2 :
                    if(v instanceof Car) {
                        System.out.print(v.getModel() + "-");
                        System.out.print(v.getBrand());
                        System.out.print('(' + v.getTotalValue() + " R$)");
                    }      
                    break;
                case 3 :
                    if(v instanceof Motorcycle) {
                        System.out.print(v.getModel() + "-");
                        System.out.print(v.getBrand());
                        System.out.print('(' + v.getTotalValue() + " R$)");
                    } 
                    break;
                case 4 :
                    return;
                default :
                    throw new IllegalArgumentException("Invalid value");
            }
        }
        
        System.out.println("\n=====================");
        System.out.print("(Press enter) >: ");
        scanner.nextLine();
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

        return null;
    }
}