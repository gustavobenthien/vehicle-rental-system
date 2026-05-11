package domain.stock;
import domain.vehicles.Car;
import domain.vehicles.Motorcycle;
import domain.vehicles.Truck;
import domain.vehicles.Vehicle;
import java.util.ArrayList;
import java.util.Scanner;

public class Stock {

    private static final ArrayList<Vehicle> vehicleStock = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public ArrayList addVehicle(int type) {

        String model;
        String brand;

        System.out.print("Vehicle model: ");
        model = scanner.nextLine();
        System.out.print("Vehicle brand: ");
        brand = scanner.nextLine();

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

        return vehicleStock;
    }

    public ArrayList removeVehicle(int type) {

        String model;
        String brand;

        System.out.println("Vehicle model: ");
        model = scanner.nextLine();
        System.out.println("Vehicle brand: ");
        brand = scanner.nextLine();

        findAndRemoveVehicle(model, brand);

        return vehicleStock;
    }

    private boolean findAndRemoveVehicle(String model, String brand) {

        for(Vehicle v : vehicleStock) {

            if(v.getModel().equalsIgnoreCase(model) && v.getBrand().equalsIgnoreCase(brand)) {
                vehicleStock.remove(v);
                return true;
            } 
            
        }

        return false;
    }
}
