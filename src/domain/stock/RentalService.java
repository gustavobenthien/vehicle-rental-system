package domain.stock;
import domain.vehicles.Vehicle;
import java.util.ArrayList;

public interface RentalService {
    void addVehicle(int type, String model, String brand, float pricing, ArrayList<Vehicle> list);

    void removeVehicle(String model, String brand, ArrayList<Vehicle> list);

    boolean showVehicles(int type, ArrayList<Vehicle> list);
    
    Vehicle searchVehicle(String model, String brand, ArrayList<Vehicle> list);
}