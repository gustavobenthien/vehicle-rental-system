package domain.stock;
import domain.vehicles.Car;
import domain.vehicles.Motorcycle;
import domain.vehicles.Truck;
import domain.vehicles.Vehicle;
import java.util.ArrayList;
import java.util.Scanner;

public class Stock {

    public static final ArrayList<Vehicle> vehicleStock = new ArrayList<>();
    public static final ArrayList<Vehicle> userRents = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Admin stock management
    // Type 1 = Truck
    // Type 2 = Car
    // Type 3 = Motorcycle

    public void addVehicle(int type, String model, String brand, ArrayList<Vehicle> list) {

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
    }

    public void removeVehicle(String model, String brand, ArrayList<Vehicle> list) {

        System.out.println("Vehicle model: ");
        model = scanner.nextLine();
        System.out.println("Vehicle brand: ");
        brand = scanner.nextLine();

        boolean isVehicle = false;

        for(Vehicle v : list) {
            if(v.getModel().equalsIgnoreCase(model) && v.getBrand().equalsIgnoreCase(brand)) {
                isVehicle = true;
            }
            
            if(isVehicle) {
                list.remove(v);
            }
        }
    }

    public void showVehicles(int type, ArrayList<Vehicle> list) {

        for(Vehicle v : list) {

            switch(type) {

                case 1 : 
                    if(v instanceof Truck) {
                        System.out.println(v.getModel());
                        System.out.println(v.getBrand() + "\n");
                    }
                    break;
                case 2 :
                    if(v instanceof Car) {
                        System.out.println(v.getModel());
                        System.out.println(v.getBrand() + "\n");
                    }      
                    break;
                case 3 :
                    if(v instanceof Motorcycle) {
                        System.out.println(v.getModel());
                        System.out.println(v.getBrand() + "\n");
                    } 
                    break;
                case 4 : // Show all
                    System.out.println(v.getModel());
                    System.out.println(v.getBrand() + "\n");
                    break;
                default :
                    throw new IllegalArgumentException("Invalid value");
            }
        }           
    }

    // User rent management

    public void rentVehicle(int type, String model, String brand) {
        
        if(type > 3 || type < 1) {
            throw new IllegalArgumentException("Invalid value!");
        }

        showVehicles(type, vehicleStock);

        System.out.print("Choose model: ");
        model = scanner.nextLine();
        System.out.print("Choose brand: ");
        brand = scanner.nextLine();

        removeVehicle(model, brand, vehicleStock);
        addVehicle(type, model, brand, userRents);
    }

    // Fix the type thing in here
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
