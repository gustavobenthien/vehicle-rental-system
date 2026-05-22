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

    public float calculateFee(Vehicle vehicle, int hours) {
        return hours * vehicle.getPricing();               
    }    

    public void clientStatus(ArrayList<Vehicle> list) {

        if(list.isEmpty()){
            System.out.println("No vehicles available at the moment.");
            return;
        }


    }
    
    @Override
    public void addVehicle(int type, String model, String brand, ArrayList<Vehicle> list) {

        while(true){
            try{
                int hours = Input.hour();
                Vehicle newVehicle;

                switch(type) {
                    case 1 :
                        newVehicle = new Truck(model, brand);
                        newVehicle.setTotalValue(calculateFee(newVehicle, hours));
                        rents.add(newVehicle);
                        break;
                    case 2 :
                        newVehicle = new Car(model, brand);
                        newVehicle.setTotalValue(calculateFee(newVehicle, hours));
                        rents.add(newVehicle);
                        break;
                    case 3 :
                        newVehicle = new Motorcycle(model, brand);
                        newVehicle.setTotalValue(calculateFee(newVehicle, hours));
                        rents.add(newVehicle);
                        break;
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

        if(list.isEmpty()) return;

        System.out.println("\n=====================");

        for(Vehicle v : list) {

            switch(type) {

                case 1 : 
                    if(v instanceof Truck) {
                        System.out.print(v.getModel() + "-");
                        System.out.println(v.getBrand());
                    }
                    break;
                case 2 :
                    if(v instanceof Car) {
                        System.out.print(v.getModel() + "-");
                        System.out.println(v.getBrand());
                    }      
                    break;
                case 3 :
                    if(v instanceof Motorcycle) {
                        System.out.print(v.getModel() + "-");
                        System.out.println(v.getBrand());
                    } 
                    break;
                case 4 :
                    return;
                default :
                    throw new IllegalArgumentException("Invalid value");
            }
        }

        System.out.println("=====================");
    }

    @Override
    public Vehicle searchVehicle(String model, String brand, ArrayList<Vehicle> list) {
        
        for(int i = 0; i < list.size(); i++) {
            Vehicle v = list.get(i);

            if(v.getModel().equalsIgnoreCase(model) && v.getBrand().equalsIgnoreCase(brand)) {
                return new Vehicle(v.getModel(), v.getBrand());
            }
        }

        return null;
    }
}