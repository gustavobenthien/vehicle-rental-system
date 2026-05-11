package domain.vehicles;

public class Vehicle {

    private String model;
    private String brand;

    public Vehicle(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }
}