package domain.stock;
import domain.vehicles.Car;
import domain.vehicles.Motorcycle;
import domain.vehicles.Truck;
import domain.vehicles.Vehicle;
import domain.vehicles.VehicleFee;
import java.util.ArrayList;
import java.util.Scanner;

public class Stock {

    public static final ArrayList<Vehicle> vehicleStock = new ArrayList<>();
    public static final ArrayList<Vehicle> userRents = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static int totalValue = 0;

    // Admin stock management
    // Type 1 = Truck
    // Type 2 = Car
    // Type 3 = Motorcycle

    public void addVehicle(int type, String model, String brand, ArrayList<Vehicle> list) {

        switch(type) {

            case 1 :
                vehicleStock.add(new Truck(model, brand));
                break;
            case 2 :
                vehicleStock.add(new Car(model, brand));
                break;
            case 3 :
                vehicleStock.add(new Motorcycle(model, brand));
                break;
            default :
                throw new IllegalArgumentException("Invalid value");
        }
    }

    public void removeVehicle(String model, String brand, ArrayList<Vehicle> list) {

        boolean isVehicle = false;

        for(int i = 0; i < list.size(); i++) {
            Vehicle v = list.get(i);

            if(v.getModel().equalsIgnoreCase(model) && v.getBrand().equalsIgnoreCase(brand)) {
                list.remove(i);
                return;
            }
        }

        System.out.println("Vehicle not found!");
    }

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

    // User rent management

    public void rentVehicle(int type, String model, String brand, int hours) {
        
        switch(type) {
            case 1 :
                totalValue = hours * VehicleFee.TRUCK.getHourFee();
                break;
            case 2 : 
                totalValue = hours * VehicleFee.CAR.getHourFee();
                break;
            case 3 :
                totalValue = hours * VehicleFee.MOTORCYCLE.getHourFee();
                break;
            default :
                throw new IllegalArgumentException("Invalid value");
        }
  
        removeVehicle(model, brand, vehicleStock);
        addVehicle(type, model, brand, userRents);
    }

    public void cancelRent(int type, String model, String brand) {

        if(userRents.isEmpty()){
            System.out.println("No rents at the moment!");
            return;
        }

        System.out.println("Choose model: ");
        model = scanner.nextLine();
        System.out.println("Choose brand: ");
        brand = scanner.nextLine();

        removeVehicle(model, brand, userRents);
        addVehicle(type, model, brand, userRents);
    }
}
